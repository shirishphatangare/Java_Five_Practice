import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Save an object state by serializing the object
// During deserialization, the class of all objs in the graph must be available to the JVM

public class SerializationAndDeserialization {

	public static void main(String[] args) {
		
		Box boxa = new Box();
		
		boxa.setLength(50);
		boxa.setWidth(30);
		boxa.setHeight(5);
		
		Label labela = new Label();
		labela.setLabelString("AMAZON");
		
		boxa.setLabel(labela);
		
		Box boxb = new Box();
		
		boxb.setLength(500);
		boxb.setWidth(300);
		boxb.setHeight(50);
		
		Label labelb = new Label();
		labelb.setLabelString("EBAY");
		
		boxb.setLabel(labelb);
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			System.out.println("Box Length - "+ boxa.getLength());
			System.out.println("Box Width - "+ boxa.getWidth());
			System.out.println("Box Height - "+ boxa.getHeight()); // Height will NOT be serialized as it is marked as transient
			System.out.println("Box Label - " + boxa.getLabel().getLabelString());
			System.out.println("Box Number (static variable) - " + boxa.boxNumber); // static variables are NOT serialized
			
			
			System.out.println("Box Length - "+ boxb.getLength());
			System.out.println("Box Width - "+ boxb.getWidth());
			System.out.println("Box Height - "+ boxb.getHeight()); // Height will NOT be serialized as it is marked as transient
			System.out.println("Box Label - " + boxb.getLabel().getLabelString());
			System.out.println("Box Number (static variable) - " + boxb.boxNumber); // static variables are NOT serialized
			
			
			System.out.println("Serializing Box object..");
			FileOutputStream fos = new FileOutputStream("box.ser");
			oos = new ObjectOutputStream(fos);
			 
			oos.writeObject(boxa);
			oos.writeObject(boxb);
			
			System.out.println("Serialization of Box object completed");
			
			System.out.println("Deserializing Box object..");
			FileInputStream fis = new FileInputStream("box.ser");
			ois = new ObjectInputStream(fis);
			
			// readObject method reads objects in the same order they were originally written
			Box box1 = (Box) ois.readObject(); // return type of readObject method is Object, so casting is must
			Box box2 = (Box) ois.readObject();
			
			System.out.println("Deserialization of Box object completed");
			
			System.out.println("Box Length - "+ box1.getLength());
			System.out.println("Box Width - "+ box1.getWidth());
			System.out.println("Box Height - "+ box1.getHeight()); // Height will get a default value for int which is 0 because as it is marked as transient
			System.out.println("Box Label - " + box1.getLabel().getLabelString()); // Entire Obj graph is serialized. If any of the object in graph is not serializable, 
			// an exception (java.io.NotSerializableException) will be thrown at runtime, unless the instance variable referring to the obj is skipped by marking it as transient
			System.out.println("Box Number (static variable) - " + box1.boxNumber);  // static variables are NOT serialized
			
			System.out.println("Box Length - "+ box2.getLength());
			System.out.println("Box Width - "+ box2.getWidth());
			System.out.println("Box Height - "+ box2.getHeight()); // Height will get a default value for int which is 0 because as it is marked as transient
			System.out.println("Box Label - " + box2.getLabel().getLabelString()); // Entire Obj graph is serialized. If any of the object in graph is not serializable, 
			// an exception (java.io.NotSerializableException) will be thrown at runtime, unless the instance variable referring to the obj is skipped by marking it as transient
			System.out.println("Box Number (static variable) - " + box2.boxNumber);  // static variables are NOT serialized

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

class Box implements Serializable {
	private static final long serialVersionUID = 4642144531459680574L;

	static int boxNumber=100;
	int length;
	int width;
	transient int height;
	Label label;
	
	
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}

class Label implements Serializable {
	private static final long serialVersionUID = -7582117272742387190L;
	String labelString;

	public String getLabelString() {
		return labelString;
	}

	public void setLabelString(String labelString) {
		this.labelString = labelString;
	}
	
}
