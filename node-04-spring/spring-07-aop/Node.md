service.UserService：接口
service.UserServiceImpl：实现类



- 方式一：通过 Spring API 实现
Spring的AOP接口中提供【AfterReturningAdvice：前置增强、MethodBeforeAdvice：后置增强 】直接实现即可：

  - log.AfterLog：前置日志
  - log.BeforeLog：后置日志





- 方式二：使用AOP的标签实现（自定义实现）
  - config.DiyPointcut

- 方式三：注解实现
  - config.AnnotationPointcut