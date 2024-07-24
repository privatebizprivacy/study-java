## 15. 입출력

### 15.1 자바에서의 입출력

### 15.1.1 입출력이란?

- 컴퓨터의 장치와 프로그램간에 데이터를 주고받는 것

### 15.1.2 스트림(Stream)

- 데이터를 운반하는데 사용되는 연결 통로

### 15.1.3 바이트기반 스트림 - InputStream, OutputStream

- 바이트 단위로 데이터를 전송하는 입출력 스트림이다.

- InputStream/OutputStream의 추상메서드 read()/write(int b)가 구현되어야 read(byte[] b)/write(byte[] b)/read(byte[] b, int off, int len)/ write(byte[] b, int off, int len)을 사용할 수 있다. 왜냐하면 후자의 메서드들은 모두 전자의 메서드를 기반으로 구현되어있기 때문이다.

### 15.1.4 보조 스트림

- 스트림의 기능을 향상 시켜주는 스트림이다. 보조 스트림만으로는 데이터를 주고 받을 수 없으며, 입출력할 수 있는 기반스트림이 반드시 필요하다.

### 15.1.5 문자기반 스트림 - Reader, Writer

- 자바에서 문자는 2byte이기때문에, 문자를 처리하는 스트림은 Reader와 Writer로 따로있다.

- 문자기반 스트림은 InputStream/OutputStream을  Reader/Writer로 바꾸면된다. 다만 byteArrayInputStream/byteArrayOutputStream의 경우에는 charArrayReader/charArrayWriter이다.

- Reader/Writer는 기반이되는 추상메서드가 read(char[] cbuf, int off, int len)과 write(char[] cbuf, int off, int len))이다.

### 15.2 바이트기반 스트림

### 15.2.1 InputStream과 OutputStream

- InputStream과 OutputStream은 바이트기반 스트림들의 조상이다.

- Stream의 종류에 따라서 mark와 reset을 통해 읽은 데이터를 다시 되돌려서 읽을 수 있다. 단, markSupported()로 mark와 reset의 기능을 지원하는지 확인하여야 한다.

- flush()는 버퍼기능있는 스트림이 아니고서는 아무런 의미가 없다.

- 스트림을 사용하고난후 close()로 반드시 닫아주어야하는데, ByteArrayInputStream같은 메모리를 대상으로 하는 스트림이나 System.in, System.out같은 표준입출력스트림은 닫아주지 않아도 된다.

### 15.2.2 ByteArrayInputStream과 ByteArrayOutputStream

- 바이트배열을 대상으로 입출력할 때 쓰는 스트림이다.

- int read(byte[] b, int off, int len)은 입력소스로부터 최대 len만큼의 데이터를 읽어서 b의 off위치부터 값을 저장한다.

- int write(byte[] b, int off, int len)은 b의 off위치부터 len만큼의 데이터를 읽어서 값을 출력소스에 저장한다.

### 15.2.3 FileInputStream과 FileOutputStream

- 파일을 대상으로 입출력할 때 쓰는 스트림이다.

- 데이터의 범위가 0~255이고, 읽을 데이터가 없음을 알리는 -1이 필요하기때문에 읽고 쓰는 단위를 int를 사용한다.

### 15.3 바이트기반 보조 스트림

### 15.3.1 FilterInputStream과 FilterOutputStream

- 모든 바이트기반 보조스트림의 조상이며, InputStream과 OutputStream의 자손이기도 하다.

- 기반스트림을 필요로하며, FilterInputStream/FilterOutputStream자체로는 아무런 의미가 없다.

- 기반스트림의 기능을 실행하는 역할을 하며, 이 스트림을 사용하려면 상속을 하여 구현하여야한다.

### 15.3.2 BufferedInputStream과 BufferedOutputStream

- 내부의 버퍼(바이트배열)을 이용하여 효율적으로 입출력하게 해주는 보조스트림이다.

- 버퍼가 가득차면 읽고 쓰는 방식이기때문에 버퍼가 가득차지 않는다면, 데이터를 읽거나 쓰지 못한다. 이때는 flush()를 통해서 버퍼의 데이터를 가져와야한다.

- close()를 호출하면 flush()를 먼저 실행하고 기반스트림의 close()를 실행한다.

### 15.3.3 DataInputStream과 DataOutputStream

- DataInput 인터페이스와 DataOutput 인터페이스를 구현하여, 기본자료형을 입출력할 수 있는 보조스트림이다.

### 15.3.4 SequenceInputStream

- 여러개의 InputStream을 하나의 InputStream처럼 사용할 수 있도록, InputStream들을 연결시켜주는 보조스트림이다.

### 15.3.5 PrintStream

- 기반 스트림에 문자 데이터를 다양한 형태로 출력할 수 있도록해주는 역할을 하는 보조스트림이다. print, printf, println을 제공하며, 우리가 흔히 쓰는 System.out객체가 PrintStream이다.

### 15.4. 문자기반 스트림

### 15.4.1 Reader와 Writer

- 모든 문자기반스트림의 조상이다. byte대신 char을 쓴다는게 특징이다. 참고로 ByteArrayInputStream/ByteArrayOutputStream은 CharArrayReader/CharArrayWriter로 대응된다.

### 15.4.2 FileReader와 FileWriter

- 파일로부터 문자데이터를 읽고 쓰는데 사용되는 문자기반스트림이다.

### 15.4.3 PipedReader와 PipedWriter

- 입출력 스트림을 연결해서 데이터를 주고 받는 문자기반스트림이다. 입출력중 하나만 닫으면 모두 닫아지는 특징이 있다.

### 15.4.4 StringReader와 StringWriter

- String을 대상으로하는 문자기반스트림이다.

### 

### 15.6.3 RandomAccessFile 클래스

- 파일의 임의의 위치에 입출력이 가능한 스트림 클래스. InputData인터페이스와 OutputData인터페이스를 상속받아서 기본 자료형 입출력이 가능하다. 또한, 파일포인터를 임의적으로 설정할 수 있어서 순차적이 아닌 임의적인 위치에서 파일을 읽고 쓸 수 있다. 파일을 쓰고난 후 읽을 때 파일포인터의 위치에 주의하여야 한다.

### 15.6.4 File

- 파일을 다루는 객체이다.

### 15.7.1 직렬화

- 객체를 스트림에 쓰기위해 연속적인 데이터로 만드는 것이 직렬화이고, 스트림에서 읽어 객체로 만드는 것이 역직렬화이다.

### 15.7.2  ObjectInputStream, ObjectOutputStream

- 직렬화/역직렬화를 수행하기위해 ObjectInputStream/ObjectOutputStream이라는 보조스트림을 사용한다.

### 15.7.3 직렬화가 가능한 클래스 만들기    -   Serializable,   transient

- 직렬화를 할려면 Serializabe을 상속받아야하며, 조상이 상속받으면 자손도 직렬화를 할 수 있다. 그러나 조상이 Serializable을 상속받지 않고, 자손이 상속을 받으면 조상의 속성들은 직렬화에서 제외된다.
- 실제로 객체 인스턴트 데이터는 속성값만 갖는다.
- Object객체는 Serializable을 상속받지 않아서 직렬화할 수 없다.
- 속성중 참조변수가 직렬화가 되냐 안되냐는 참조 변수가 아니라 연결된 객체의 종류에 따라 결정된다.
- 속성중 직렬화를 시키지 않으려면 앞에 transient를 붙이면 된다.

### 15.7.4 직렬화가능한 클래스의 버전관리

- serializble을 상속받으면, 멤버들을 기반으로 고유의 serialVersionUID를 받는다. 이 UID로 직렬화시 클래스들을 구분한다.
- private static final long serialVersionUID를 선언하고 초기화하여 serialVersionUID를 정의할 수 있다.