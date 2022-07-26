package all.Aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class BookAspect {
    @Pointcut("execution(* all.controller.BookController.book*(..))")
    public void allMethodPointCut() {
    }

    @After("allMethodPointCut()")
    public void afterCallMethod() {
        System.err.println("Sách đã bị thay đổi lúc " + LocalDateTime.now());
    }
}
