package group.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MyClass {
    // Additional code for the property change support
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    // Regular class body
    // Static field for the property name
    public static final String FIELD1_PROPERTY = "field1";

    private String field1;

    public String getField1() {
        return this.field1;
    }

    public void setField1(String newValue) {
        String oldValue = this.field1;
        this.field1 = newValue;
        // Setting a new value will fire a property change event for the listener
        this.pcs.firePropertyChange(FIELD1_PROPERTY, oldValue, newValue);
    }

    // Static field for the property name
    public static final String FIELD2_PROPERTY = "field2";

    private int field2;

    public int getField2() {
        return this.field2;
    }

    public void setField2(int newValue) {
        int oldValue = this.field2;
        this.field2 = newValue;
        // Setting a new value will fire a property change event for the listener
        this.pcs.firePropertyChange(FIELD2_PROPERTY, oldValue, newValue);
    }
}
