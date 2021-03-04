package utilities;

import java.beans.PropertyChangeListener;

public interface NamedPropertyChangeSubject
{
  public void addListener(String namedProperty, PropertyChangeListener listener);
  public void removeListener(String namedProperty, PropertyChangeListener listener);
}
