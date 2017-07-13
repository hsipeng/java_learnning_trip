package beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
public class Person implements BeanNameAware{
	@Value(value="${id}")
	private int id;
	@Value(value="${name}")
	private String name;
	@Value("#{@list}")
	private List list;
	@Value("#{@set}")
	private Set set;
	@Value("#{@map}")
	private Map map;
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", list=" + list + ", set=" + set + ", map=" + map + ", dog="
				+ dog + ", cat=" + cat + "]";
	}
	@Resource
	private Dog dog;
	@Resource
	private Cat cat;
	
	
	@PostConstruct
	public void init(){
		System.out.println("init");
	}
	@PreDestroy
	public void destory(){
		System.out.println("destory");
	}
	public Dog getDog() {
		return dog;
	}
	@Scope
	@Lazy
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	public Cat getCat() {
		return cat;
	}
	public void setCat(Cat cat) {
		this.cat = cat;
	}
	
	public void shit(){
		dog.eat();
		cat.eat();
	}
	@Override
	public void setBeanName(String arg0) {
		System.out.println(arg0);
		
	}
}
