package com.xdao.util;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xdao.dto.HasId;
import com.xdao.dao.exception.IncorrectParameterException;

/**
 * This is util class which uses for validate fields, object in service layer.
 */
public class Validator {
  /* The constant LOG */
  private static final Logger LOG = LoggerFactory.getLogger(Validator.class);

  private Validator() {
  }

  /**
   * This method validate string id. Id is a string object which will be
   * converted to <code>ObjectId</code> in domain model classes. If id is empty or could not be
   * converted to <code>ObjectId</code> than return <code>false</code>
   *
   * @param id the id
   * @return the boolean
   */
  public static boolean isValidId(String id) {
    boolean correct = false;
    if (StringUtils.isNotEmpty(id)) {
      correct = true;
    }
    return correct;
  }

  /**
   * This method validate if string id is not empty.
   *
   * @param id the string id
   * @return the boolean
   */
  public static boolean isValidSqlId(String id) {
    return StringUtils.isNotEmpty(id);
  }

  /**
   * This method check if hash not equals <code>null</code>.
   * Possible will be add validation pattern.
   *
   * @param hash the hash
   * @return the boolean result
   */
  public static boolean isValidHash(byte[] hash) {
    boolean correct = false;
    if (hash != null) {
      correct = true;
    }
    return correct;
  }

  /**
   * Checks whether the given identifiable object is not <code>null</code>.
   *
   * @param object An identifiable object to check
   * @return <code>true</code> if the argument is not null, <code>false</code> otherwise
   */
  public static boolean isValidObject(HasId object) {
    return object != null;
  }

  /**
   * Checks whether the given object's ID is blank or can be parsed as <code>long</code>.
   *
   * @param object An identifiable object to check
   * @return <code>true</code> if the given object's ID is blank or can be parsed as
   * <code>long</code>, <code>false</code> otherwise.
   */
  public static boolean isValidSqlObject(HasId object) {
    boolean correct = false;

    if (object != null) {
      String id = object.getId();
      if (StringUtils.isNotBlank(id)) {
        try {
          Long.parseLong(id);
          correct = true;
        } catch (NumberFormatException cause) {
          LOG.debug("Exception during ID validation: the ID is not blank, but cannot be parsed as "
                    + "long.");
        }
      } else {
        correct = true;
      }
    }

    return correct;
  }

  /**
   * This method validate <code>String</code> id. If id is invalid than throw
   * <code>IncorrectParameterException</code> exception
   *
   * @param id           the id
   * @param errorMessage the error message for exception
   */
  public static void validateId(String id, String errorMessage) {
    if (!isValidId(id)) {
      throw new IncorrectParameterException(errorMessage);
    }
  }

  /**
   * @param id           the id.
   * @param errorMessage the error message for exception
   */
  public static void validateSqlId(String id, String errorMessage) {
    try {
      Long.valueOf(id);
    } catch (NumberFormatException ex) {
      throw new IncorrectParameterException(errorMessage, ex);
    }
  }

  /**
   * This method validate <code>String</code> string. If string is invalid than throw
   * <code>IncorrectParameterException</code> exception
   *
   * @param id           the id
   * @param errorMessage the error message for exception
   */
  public static void validateString(String id, String errorMessage) {
    if (id == null || id.isEmpty()) {
      throw new IncorrectParameterException(errorMessage);
    }
  }

  /**
   * This method validates <code>Object</code> object. If object is not null than throw
   * <code>IncorrectParameterException</code> exception
   *
   * @param obj          the obj
   * @param errorMessage the error message for exception
   */
  public static void validateNull(Object obj, String errorMessage) {
    if (obj != null) {
      throw new IncorrectParameterException(errorMessage);
    }
  }

  /**
   * This method validates <code>Object</code> object. If object is null than throw
   * <code>IncorrectParameterException</code> exception
   *
   * @param obj          the obj
   * @param errorMessage the error message for exception
   */
  public static void validateNotNull(Object obj, String errorMessage) {
    if (obj == null) {
      throw new IncorrectParameterException(errorMessage);
    }
  }

  /**
   * This method validate <code>byte</code> array hash. If hash is invalid than throw
   * <code>IncorrectParameterException</code> exception
   *
   * @param hash         the hash
   * @param errorMessage the error message for exception
   */
  public static void validateHash(byte[] hash, String errorMessage) {
    if (!isValidHash(hash)) {
      throw new IncorrectParameterException(errorMessage);
    }
  }

  /**
   * This method validate <code>HasId</code> object. If object is invalid than throw
   * <code>IncorrectParameterException</code> exception
   *
   * @param hasId        the hash id
   * @param errorMessage the error message for exception
   */
  public static void validateObject(HasId hasId, String errorMessage) {
    if (!isValidObject(hasId)) {
      throw new IncorrectParameterException(errorMessage);
    }
  }

  /**
   * This method validate <code>HasId</code> object. If object is invalid than throw
   * <code>IncorrectParameterException</code> exception
   *
   * @param hasId        the hash id
   * @param errorMessage the error message for exceptio
   */
  public static void validateSqlObject(HasId hasId, String errorMessage) {
    if (!isValidSqlObject(hasId)) {
      throw new IncorrectParameterException(errorMessage);
    }
  }

}
