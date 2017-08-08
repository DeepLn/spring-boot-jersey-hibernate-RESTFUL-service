package com.xdao.util;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xdao.dao.model.ToDto;
import com.xdao.dao.model.GenericModel;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The Class DaoUtil.
 */
public abstract class DaoUtil {

  /**
   * The Constant LOG.
   */
  private static final Logger LOG = LoggerFactory.getLogger(DaoUtil.class);

  private DaoUtil() {
  }

  /**
   * This method take string id from <code>GenericModel</code> object.
   *
   * @param model <code>GenericModel</code> object
   * @return the id as string type
   */
  public static String idToString(GenericModel<? extends Object> model) {
    String id = null;
    if (model != null) {
      Long lid = model.getId();
      id = lid != null ? lid.toString() : null;
    }
    return id;
  }

  /**
   * This method convert Long id to String object.
   *
   * @param lid basic mongoDB id object type.
   * @return converted to string id.
   */
  public static String idToString(Long lid) {
    String id = null;
    if (lid != null) {
      id = lid.toString();
    }
    return id;
  }

  /**
   * This method  convert list of model objects to dto objects.
   *
   * @param <T>       Type of model object
   * @param toDtoList List of model objects.
   * @return List of converted objects.
   */
  public static <T> List<T> convertDtoList(Collection<? extends ToDto<T>> toDtoList) {
    List<T> list = Collections.emptyList();
    if (toDtoList != null && !toDtoList.isEmpty()) {
      list = new ArrayList<>();
      for (ToDto<T> object : toDtoList) {
        list.add(object.toDto());
      }
    }
    return list;
  }

  /**
   * This method  convert list of model objects to dto objects.
   *
   * @param <T>      Type of model object
   * @param toDtoSet List of model objects.
   * @return List of converted objects.
   */
  public static <T> Set<T> convertDtoSet(Collection<? extends ToDto<T>> toDtoSet) {
    Set<T> set = Collections.emptySet();
    if (toDtoSet != null && !toDtoSet.isEmpty()) {
      set = new HashSet<>();
      for (ToDto<T> object : toDtoSet) {
        set.add(object.toDto());
      }
    }
    return set;
  }

  /**
   * This method  convert model object to dto object.
   *
   * @param <T> Type of model object
   * @param dto Model object
   * @return converted object
   */
  public static <T> T getDto(ToDto<T> dto) {
    T object = null;
    if (dto != null) {
      object = dto.toDto();
    }
    return object;
  }

  /**
   * This method use for coping array bytes.
   *
   * @param array bytes
   * @return copied array of bytes
   */
  public static byte[] getArrayCopy(byte[] array) {
    byte[] bytes = null;
    if (array != null) {
      bytes = Arrays.copyOf(array, array.length);
    }
    return bytes;
  }

}
