package com.xdao.dao.model;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.xdao.dto.HasId;
import com.xdao.dao.model.ToDto;

public class ModelUtils {

  public static final String UTF8 = "UTF-8";
  private static final Logger LOG = LoggerFactory.getLogger(ModelUtils.class);

  private ModelUtils() {
    throw new UnsupportedOperationException("Not supported");
  }

  public static String getStringId(Long longId) {
    return longId != null ? longId.toString() : null;
  }

  /**
   * Get string id.
   *
   * @param hasId the object that has id
   * @return id
   */
  public static String getStringId(GenericModel<?> hasId) {
    String stringId = null;
    if (hasId != null) {
      Long id = hasId.getId();
      stringId = getStringId(id);
    }
    return stringId;
  }

  /**
   * Get Long id from object with id.
   *
   * @param hasId the object with id
   * @return id
   */
  public static Long getLongId(HasId hasId) {
    Long longId = null;
    if (hasId != null) {
      String id = hasId.getId();
      longId = getLongId(id);
    }
    return longId;
  }

  /**
   * Get Long id from string.
   *
   * @param id the id string
   * @return Long id
   */
  public static Long getLongId(String id) {
    Long longId = null;
    if (isNotBlank(id)) {
      try {
        longId = Long.valueOf(id);
      } catch (NumberFormatException ex) {
        LOG.error("Can't convert to Long id. Incorrect String id {} ", id);
      }
    }
    return longId;
  }

}
