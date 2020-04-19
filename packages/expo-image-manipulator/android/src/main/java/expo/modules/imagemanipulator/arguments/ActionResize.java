package expo.modules.imagemanipulator.arguments;

import androidx.annotation.NonNull;

import java.util.Map;

public class ActionResize {
  private static final String TAG = "action.resize";

  private static final String KEY_WIDTH = "width";
  private static final String KEY_HEIGHT = "height";
  private static final String KEY_MODE = "mode";

  @NonNull
  private final Integer mWidth;
  @NonNull
  private final Integer mHeight;
  private final ActionResizeMode mMode;

  private ActionResize(@NonNull Integer width, @NonNull Integer height, ActionResizeMode mode) {
    mWidth = width;
    mHeight = height;
    mMode = mode;
  }

  static ActionResize fromObject(Object options) {
    if (!(options instanceof Map<?, ?>)) {
      throw new IllegalArgumentException("'" + TAG + "' must be an object");
    }
    Map optionsMap = (Map) options;

    int width = 0;
    if (optionsMap.containsKey(KEY_WIDTH)) {
      if (!(optionsMap.get(KEY_WIDTH) instanceof Double)) {
        throw new IllegalArgumentException("'" + TAG + "." + KEY_WIDTH + "' must be a Number value");
      }
      width = ((Double) optionsMap.get(KEY_WIDTH)).intValue();
    }

    int height = 0;
    if (optionsMap.containsKey(KEY_HEIGHT)) {
      if (!(optionsMap.get(KEY_HEIGHT) instanceof Double)) {
        throw new IllegalArgumentException("'" + TAG + "." + KEY_HEIGHT + "' must be a Number value");
      }
      height = ((Double) optionsMap.get(KEY_HEIGHT)).intValue();
    }

    ActionResizeMode mode = ActionResizeMode.fromObject("stretech");
    if (optionsMap.containsKey(KEY_MODE)) {
      mode = ActionResizeMode.fromObject(options.get(KEY_MODE));
    }

    return new ActionResize(width, height, mode);
  }

  @NonNull
  public Integer getWidth() {
    return mWidth;
  }

  @NonNull
  public Integer getHeight() {
    return mHeight;
  }

  public String getMode() {
    return mMode.getMode();
  }
}
