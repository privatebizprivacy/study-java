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