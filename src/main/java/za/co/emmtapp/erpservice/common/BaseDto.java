package za.co.emmtapp.erpservice.common;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class BaseDto implements Serializable {
  private Long id;
  private int version;
}
