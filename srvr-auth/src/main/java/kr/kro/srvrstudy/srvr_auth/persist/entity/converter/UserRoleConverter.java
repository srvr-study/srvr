package kr.kro.srvrstudy.srvr_auth.persist.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import kr.kro.srvrstudy.srvr_auth.persist.entity.UserRole;

@Converter
public class UserRoleConverter implements AttributeConverter<UserRole, String>{

  @Override
  public String convertToDatabaseColumn(UserRole attribute) {
    return attribute.toString();
  }

  @Override
  public UserRole convertToEntityAttribute(String dbData) {
    return UserRole.from(dbData);
  }
  
}
