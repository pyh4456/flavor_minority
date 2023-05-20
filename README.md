# 맛소수자(flavor_minority)
 
### 1. 프로젝트 소개 
맛소수자(flavor_minority)는 사용자 주변의 음식점에서 사용자가 기피 하는 재료를 사용하는지 알려주는 서비스다.

### 2. 시스템 구성도
 ![image](https://github.com/pyh4456/flavor_minority/assets/62279820/0917e841-559b-4b8d-b24f-c6129ce6d0ce)
 
 전체적인 통신방식은 위와 같다. Application에서 WebServer를 통해 database에 접근하며, database의 데이터를 기반으로 화면을 구성한다.

상세 구조
![image](https://github.com/pyh4456/flavor_minority/assets/62279820/54ec5b4e-a869-4d79-be6d-1060b7141bb7)

프로젝트의 시스템 구성도는 위의 그림과 같다. 프로젝트는 크게 클라이언트와 서버 부분으로 나뉜다. 클라이언트 프로그램은 유저가 인터페이스를 통해 여러 종류의 값을 입력하게 하고, 그 값들을 DB에 넘겨줄 준비를 한다. 또한 GPS를 통하여 사용자의 위치정보를 알아내는 것을 담당하고 있다. 서버에서는 클라이언트에서 보낸 값들을 전송 페이지를 통해 DB에 입력해준다. 또 웹앱으로 로그인 페이지, 지도 등의 여러 페이지들을 서버를 통해 보여준다.

프로젝트를 세부적으로 나누면 외부 API, 안드로이드 액티비티, 안드로이드 객체, 웹뷰로 보이는 페이지, 데이터 전송용 페이지, 데이터 접근 객체로 나눌 수 있다. 외부 API로는 카카오맵 API를 가져와 지도로 사용하였다. 안드로이드 액티비티는 주로 눈에 보이는 레이아웃들을 표시하고, 유저가 정보를 기입할 수 있게 구현하였다. 안드로이드 객체는 위치정보나 유저 데이터 등 정보들을 전달하거나 가져오는 역할을 수행한다. 데이터 객체는 DB에 직접 접근하여 정보를 입력할 수 있게 해준다. 웹뷰로 보이는 페이지와 데이터 전송용 페이지는 말 그대로 역할을 수행한다.

### 3. 프로젝트 주요기능
#### 1) 로그인 및 회원가입 기능
![image](https://github.com/pyh4456/flavor_minority/assets/62279820/6a585c1d-7a3a-4883-9ce2-244643bc8222)

앱을 시작하면 로그인 화면부터 시작한다. 이 Activity에서는 WebView를 통해 웹서버의 로그인 페이지를 보여준다. 각 페이지에서 MemberDAO객체를 통해 데이터 베이스에 접근하며 사용자가 입력한 아이디가 등록되어 있지 않거나 비밀번호가 틀리면 다시 페이지를 로드해서 사용자에게 문제를 알려준다. 로그인 성공시 현재 Activity를 종료하고 지도를 띄우는 Activity로 이동하며 사용자 정보를 보내준다.
 로그인 화면의 회원가입 버튼을 누르면 회원가입 페이지로 이동한다. 사용자가 회회원가입 시도할 때, 아이디의 중복체크를 하고 데이터베이스에 중복된 아이디가 존재하면 사용자에게 알려준다. 회원가입 성공 시 로그인 화면으로 돌아간다.

#### 2) 지도 출력
![image](https://github.com/pyh4456/flavor_minority/assets/62279820/9a8205eb-2f04-46f4-b329-293a983f6e4d)
![image](https://github.com/pyh4456/flavor_minority/assets/62279820/6ce6ff33-5e13-4eda-af5e-f9c52200bc6c)

지도 화면            마커클릭시 이벤트 발생

로그인 성공 시 실행되는 Activity의 화면이다. 이 Activity에서 GPS기능을 이용해서 사용자의 위치를 알아내 웹뷰에 띄워진 JSP페이지로 보내준다. JSP에서 데이터 접근 객체를 통해 테이터 베이스에 접근한다. 사용자의 위치 주변의 가게들을 마커로 표시한다. 이 때, 각 가게의 메뉴 정보와 사용자의 기피재료정보를 토대로 사용자가 기피하는 재료를 가게가 사용한다면 마커의 색깔이 빨간색, 그렇지 않으면 초록색이 된다. 화면 중앙의 파란색 마커는 사용자의 위치이다.

#### 3) 유저의 기피재료 선택
![image](https://github.com/pyh4456/flavor_minority/assets/62279820/df978d49-7830-4677-9386-aa95119ed240)

지도 화면에서 SETTING버튼 클릭 시 실행되는 Activity. 사용자의 기피재료 정보를 저장하며 제출버튼을 누르면 앱 내부의 DBConnectHelper모듈로 서버에 사용자 정보를 보낸다. 데이터베이스에 사용자 정보를 저장하면 지도화면을 다시 띄운다.

#### 4) 가게의 상세정보 출력
![image](https://github.com/pyh4456/flavor_minority/assets/62279820/7e37f17e-b9e5-44af-ac36-dbc051e4a310)

지도 화면에서 마커를 두번 연속해서 클릭 시 이벤트가 발생해서 해당 가게의 상세정보를 보여주는 Activity를 실행한다. 지도를 띄우는 jsp에서 데이터베이스에 접근해 가게의 이름과 음식데이터를 네이티브로 보내고 이를 토대로 activity를 구성한다. 맨 위에 가게의 이름을 띄우고, 등록된 음식들의 재료들을 ListView로 보여준다. 음식추가 버튼을 클릭하면 음식을 추가로 등록 할 수 있다.

#### 5) 음식 추가 등록
![image](https://github.com/pyh4456/flavor_minority/assets/62279820/aa7efe03-0af3-4170-a0a1-971868cee365)

 음식의 이름, 들어간 재료, 제외 가능 여부를 입력하여 제출하면 DBConnectHelpper모듈로 서버와 통신해 데이터베이스에 음식을 등록한다.

#### 6) 서버와 activity간의 통신
##### (1) WebView를 이용한 통신.
![image](https://github.com/pyh4456/flavor_minority/assets/62279820/510ecda9-0b02-4751-87c3-482ee7564165)

WebViewClientclass의 shouldOverrideUrlLoading을 오버라이딩 한다. WebView에서 새롭게 페이지를 로드할 때, 해당 URL이 “app://”으로 시작하면 URL에 담긴 정보를 액티비티에서 사용할 수 있게 했다. 
##### (2) DBConnectHelper (WebView를 이용하지 않은 통신)
 안드로이드는 보안상의 이유로 외부 라이브러리를 사용할 수 없기 때문에, 안드로이드 스튜디오와 MySQL DB를 연결하려면 중간 매개체가 필요하다. 그런 이유로 dbsender.jsp라는 jsp파일로 연동을 해줬다. 먼저 jsp에서 언어를 java로 설정해주고 sql모듈을 사용해야 하므로 해당 모듈을 import 해준다. DB에 실행할 statement를 정의해 입력해주고 try-catch문을 통해 DB주소와 포트, 사용자 비밀번호 정보를 입력하여 DriverManager클래스의 getConnection()함수로 데이터베이스에 연결을 해준다. 이후에 입력한 statement를 execute하여 통신을 마무리한다. 
액티비티에서 jsp로 데이터를 넘겨줄 때는 AsyncTask를 사용했다. AsyncTask클래스의 doInBackground()에서 받아올 String변수를 설정하고, jsp파일 주소를 입력하여 연결해준다. 받아온 변수를 “UTF-8”형식으로 encode하여 저장하고, BufferedWriter로 데이터를 flush()해주면 액티비티에서 보낸 데이터가 jsp에 성공적으로 전송된다.

#### 7) 데이터베이스 구조
데이터베이스는 MySQL를 이용한다. 세개의 table을 사용하며 각각 유저정보, 가게정보, 음식 정보를 포함한다.
##### (1)	유저정보
![image](https://github.com/pyh4456/flavor_minority/assets/62279820/e0b4033c-f0a2-44d1-92ef-68b7c8c15678)

유저의 아이디, 비밀번호, 이름, 기피하는 재료에 대한 정보를 저장한다.

##### (2)	가게 정보
![image](https://github.com/pyh4456/flavor_minority/assets/62279820/1bfda5c3-6976-40f6-b83b-f55d7ae42745)

가게들의 이름, 위치, 재료들에 대한 정보를 저장한다. 위치는 위도와 경도로 저장한다. 각 재료들에 대한 정보는 길이가 2인 bitstream으로 저장하며 오른쪽 bit가 재료가 들어있는지, 오른쪽 bit가 재료를 뺄 수 있는지에 대한 정보다.
##### (3)	음식 정보
![image](https://github.com/pyh4456/flavor_minority/assets/62279820/0c0ac4be-1f37-4bb6-8cfb-f78dc1419ba3)
 
모든 가게에 대한 음식의 정보는 하나의 테이블로 관리한다. 가게의 이름, 음식의 이름, 재료에 대한 정보를 저장한다. 재료에 대한 정보의 규칙은 가게정보의 것과 같다.
