package com.taobao.secondbundle.db;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @ Description:
 * @ Author king
 * @ Date 2017/9/11 16:27
 * @ Version V1.0
 */

@Entity(nameInDb = "tb_person")
public class Person  implements Serializable{
  private static final long serialVersionUID = 4556257525820236922L;

  @Id(autoincrement = true)
  public   Long   id;

  @Property
  public  String  name;

  @Generated(hash = 628813901)
  public Person(Long id, String name) {
      this.id = id;
      this.name = name;
  }

  @Generated(hash = 1024547259)
  public Person() {
  }

  public Long getId() {
      return this.id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

  public void setName(String name) {
      this.name = name;
  }
}
