package com.atlas.threebundle.db;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @ Description:
 * @ Author king
 * @ Date 2017/9/11 15:37
 * @ Version V1.0
 */

@Entity(nameInDb = "tb_user")
public class User  implements Serializable {

  private static final long serialVersionUID = -8380539922361571221L;

  @Property(nameInDb = "id")
  @Id(autoincrement = true)
  public   Long   id;

  @Property
  public   String   name;

  @Generated(hash = 873297011)
  public User(Long id, String name) {
      this.id = id;
      this.name = name;
  }

  @Generated(hash = 586692638)
  public User() {
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
