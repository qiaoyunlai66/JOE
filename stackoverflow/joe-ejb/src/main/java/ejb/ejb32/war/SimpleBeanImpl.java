package ejb.ejb32.war;

import javax.ejb.Stateless;

/**
 * @author Joe Qiao
 * @Date 08/04/2018.
 */
@Stateless(name="Example", mappedName="ejb/SimpleBeanJNDI")
public class SimpleBeanImpl implements SimpleBean{
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}
