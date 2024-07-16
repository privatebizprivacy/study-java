package ch15;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Conn {
    public static void main(String[] args) {

            

            String loginUrl = "https://local.pmi.co.kr/auth/loginProc.do";
            String targetUrl = "https://local.pmi.co.kr/common/cs/promotionc/uploadFile.do"; // 서버 URL로 변경하세요
            String filePath = "C:\\Users\\ilsong_dev\\Downloads\\34지면광고_피트라인맨페이스밸런스&프로텍트_피엠인터내셔널코리아_2024.03(pdf.io).pdf"; // 업로드할 PDF 파일 경로로 변경하세요

            try {

                disableSSLVerification();

                String sessionId = loginAndGetSessionId(loginUrl, "7810412", "ilsong12");
                System.out.println(sessionId);
                if (sessionId != null) {
                    File pdfFile = new File(filePath);
                    uploadFile(targetUrl, pdfFile, sessionId);
                } else {
                    System.out.println("Login failed.");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    private static void disableSSLVerification() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Trust all hostnames
        HostnameVerifier allHostsValid = (hostname, session) -> true;
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    }

    private static String loginAndGetSessionId(String loginUrl, String username, String password) throws IOException {
        URL url = new URL(loginUrl);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String urlParameters = "mbid2=" + username + "&webpassword=" + password;
        OutputStream os = httpConn.getOutputStream();
        os.write(urlParameters.getBytes());
        os.flush();
        os.close();

        int responseCode = httpConn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            List<String> fields =  httpConn.getHeaderFields().get("Set-Cookie");
            for(String value : fields) {
                if(value.startsWith("JSESSIONID")){
                    return value.split("=")[1];
                }
            }
        }

        return null;
    }

    public static void uploadFile(String targetUrl, File file, String sessionId) throws Exception {
        String boundary = "----WebKitFormBoundary" + Long.toHexString(System.currentTimeMillis());
        String LINE_FEED = "\r\n";

        HttpURLConnection httpConn = (HttpURLConnection) new URL(targetUrl).openConnection();
        httpConn.setUseCaches(false);
        httpConn.setDoOutput(true); // 서버에 데이터를 보냄을 명시
        httpConn.setDoInput(true); // 서버로부터 데이터를 받음을 명시
        httpConn.setRequestMethod("POST");
        httpConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
        httpConn.setRequestProperty("Cookie", "JSESSIONID=" + sessionId); // 세션 ID 설정

        OutputStream outputStream = httpConn.getOutputStream();
        outputStream.write(("--" + boundary + LINE_FEED).getBytes());
        outputStream.write(("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"" + LINE_FEED).getBytes());
        outputStream.write(("Content-Type: application/pdf" + LINE_FEED).getBytes());
        outputStream.write(LINE_FEED.getBytes());

        FileInputStream inputStream = new FileInputStream(file);
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.write(LINE_FEED.getBytes());
        outputStream.write(("--" + boundary + "--" + LINE_FEED).getBytes());
        outputStream.flush();
        inputStream.close();
        outputStream.close();

        int responseCode = httpConn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("File uploaded successfully.");
        } else {
            System.out.println("File upload failed. Response code: " + responseCode);
        }

        httpConn.disconnect();
    }
    
}
