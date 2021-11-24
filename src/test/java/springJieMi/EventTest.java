package springJieMi;

import mapper.ruanxinxin.mvc01.employee.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import java.util.EventListener;
import java.util.EventObject;

public class EventTest {
    Person person = new Person();
    EventObject eventObject = new EventObject(person);
    EventListener eventListener=new EventListener() {
    };

}
