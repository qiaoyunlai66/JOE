package ejb.ejb32.war;

import javax.ejb.Remote;

/**
 * @author Joe Qiao
 * @Date 08/04/2018.
 */
@Remote
public interface SimpleBean {
    public String sayHello(String name);
}
