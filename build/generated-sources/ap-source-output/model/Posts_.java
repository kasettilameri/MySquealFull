package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-11T20:06:26")
@StaticMetamodel(Posts.class)
public class Posts_ { 

    public static volatile SingularAttribute<Posts, Integer> imageID;
    public static volatile SingularAttribute<Posts, String> filename;
    public static volatile SingularAttribute<Posts, Date> pDate;
    public static volatile SingularAttribute<Posts, String> title;

}