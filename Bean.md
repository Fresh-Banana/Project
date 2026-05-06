## Bean
- `정의:` 스프링 컨테이너에 등록한 객체를 **스프링 빈**이라고 함
    - 객체를 스프링이 생성하기 해주기 위해서는 권한을 넘겨야 함 그래서 등록임
## 등록 방법
- XML파일 직접 생성(거의 사용되지 않음)
- 어노테이션 기반 설정(@component,service,repositor,controller)
    - 각각의 어노테이션에 미리 코드로 등록 됌
- 직관전으로 설정
    - @Configuration과 @Bean 더 명시적으로 쓰고 싶을때
## 이해하고 활용하려는 이유
- UserService,Repository에 강하게 결합 되어 Repository의 코드를 수정할때 적은 코드를 고칠수 있어 용이하다
## Ioc(제어의 역전)
- `정의:` 생명주기의 제어권을 넘김
- Bean의 제어권을 넘기면서 주입성과 생명주기를 spring container가 관리해준다
## BeanFactory
- `정의` Bean을 실질적으로 관리하는 컨테이너다
## Di
- `정의:` 의존성 주입

## 최종
- 스프링에게 제어권을주면서 spring container가 Di(의존성 주입)을 해주면서 객체 Bean의 생명주기를 관리해준다