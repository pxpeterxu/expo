package expo.modules.imagemanipulator.arguments;

public enum ActionResizeMode {
  STRETCH("stretch"),
  COVER("cover"),
  CONTAIN("contain");

  private final String mMode;

  ActionResizeMode(String mode) {
    mMode = mode;
  }

  static public ActionResizeMode fromObject(Object o) throws IllegalArgumentException {
    String errorMessage = "Resize 'mode' must be one of ['stretch', 'cover', 'contain']. Obtained '" + o.toString() + "'";
    if (!(o instanceof String)) {
      throw new IllegalArgumentException(errorMessage);
    }
    for (ActionResizeMode m : values()) {
      if (m.mMode.equals(o)) {
        return m;
      }
    }
    throw new IllegalArgumentException(errorMessage);
  }

  public String getMode() {
    return mMode;
  }
}
