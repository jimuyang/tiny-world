# 一步一步实现一个tiny-spring

抄袭了craft4code的代码，自己加入了注释


### tiny-spring总体流程
```
总体来说，tiny-spring 的 ApplicaitonContext 使用流程是这样的： 
1. ApplicationContext 完成了类定义的读取和加载，并注册到 BeanFactory 中去。 
2. ApplicationContext 从 BeanFactory 中寻找 BeanPostProcessor，注册到 BeanFactory 
维护的 BeanPostProcessor 列表中去。 
3. ApplicationContext 以单例的模式，通过主动调用 getBean 实例化、注入属性、然后初始化 BeanFactory 中所有的 Bean。
由于所有的 BeanPostProcessor 都已经在第 2 步中完成实例化了，因此接下来实例化的是普通 Bean，因此普通 Bean 的初始化过程可以正常执行。 
4. 调用 getBean 时，委托给 BeanFactory，此时只是简单的返回每个 Bean 单例，因为所有的 Bean 实例在第三步都已经生成了

```


### 动态代理的步骤
```
1. AutoProxyCreator（实现了 BeanPostProcessor 接口）在实例化所有的 Bean 前，最先被实例化。
2. 其他普通 Bean 被实例化、初始化，在初始化的过程中，AutoProxyCreator 加载 BeanFactory 中所有的 PointcutAdvisor（
这也保证了 PointcutAdvisor 的实例化顺序优于普通 Bean。），然后依次使用 PointcutAdvisor 内置的 ClassFilter，判断当前对象是不是要拦截的类。
3. 如果是，则生成一个 TargetSource（要拦截的对象和其类型），并取出 AutoProxyCreator 的 MethodMatcher（对哪些方法进行拦截）、Advice（拦截的具体操作），
再交给 AopProxy 去生成代理对象。
4. AopProxy 生成一个 InvocationHandler，在它的 invoke 函数中，首先使用 MethodMatcher 判断是不是要拦截的方法，如果是则交给 Advice 来执行
（Advice 由用户来编写，其中也要手动/自动调用原始对象的方法），如果不是，则直接交给 TargetSource 的原始对象来执行。
```

