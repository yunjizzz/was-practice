
### WAS의 동작구조

Web application server는 어떻게 동작할까?  
대표적으로 사용하는 was인 Tomcat을 사용한다면 아래 부분은 개발자가 직접 개발할 경우는 많이 없다.  
그래도 어떻게 동작하는지 직접 구현하며 이해해 보도록 하자.


### step1
-  [commit](https://github.com/yunjizzz/was-practice/commit/5bd1166e6ffb6109b3ac1f75fef1c4a2092afa63)
- 사용자 요청을 위한 메인 스레드가 처리하도록 한다.
- 이 경우 스레드가 1개이기 때문이 하나의 처리가 완료될 때까지 기다려야 하는 단점이 있다.
- 이를 보완하기 위해 step2에서는 Thread를 여러개 사용해보자.

### step2
-  [commit](https://github.com/yunjizzz/was-practice/commit/5bd1166e6ffb6109b3ac1f75fef1c4a2092afa63)
- 사용자 요청이 들어올 때 마다 Thread를 새로 생성해서 사용자 요청을 처리하도록 한다.
- 동시 접속자수가 많아질 경우 cpu, 메모리 사용량이 증가해 서버 리소스 사용량이 증가해 최악의 경우 서버가 다운 될 수도 있다.
- 이를 방지하기 위해 step3에서는 Thread Pool을 적용해보자.

### step3 
- [commit](https://github.com/yunjizzz/was-practice/commit/52b06ae921de904dcf70578b675fa89f11c30fa8)
- Thread pool을 이용해서 안정적으로 Thread를 관리할 수 있도록  하자.
