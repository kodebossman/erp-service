package za.co.emmtapp.erpservice.common;


import jakarta.persistence.*;
import lombok.ToString;

import java.io.Serializable;

@ToString
@MappedSuperclass
public abstract class BaseEntity
  implements Serializable {

  private Long id;
  private int version;
  private Boolean deleted = false;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Version
  @Column(name = "version")
  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  @Column(name = "deleted")
  public boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }
}
