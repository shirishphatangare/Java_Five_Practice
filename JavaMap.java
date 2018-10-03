import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class JavaMap {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<Name,String> phoneBook = new HashMap<Name,String>();
        List<String> outputList = new ArrayList<String>();
        
        int n = Integer.valueOf(scanner.nextLine());
        
        for(int i=0; i<n; i++) {
            String[] name = scanner.nextLine().split(" ");
            Name fullName = null;
            
            if(name.length == 1) {
                fullName = new Name(name[0]); 
            }else {
                fullName = new Name(name[0],name[1]);
            }
            
            String phoneNumber = scanner.nextLine();
            phoneBook.put(fullName, phoneNumber);        
        }

        
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.isEmpty())
                break;
            
            String[] query = line.split(" ");
            
            Name fullName = null;
            String outputformat = null;
            
            if(query.length == 1) {
                fullName = new Name(query[0]); 
            }else {
                fullName = new Name(query[0],query[1]);
            }
            
            String phoneNumber = phoneBook.get(fullName);
            
            if(phoneNumber == null) {
                outputformat = "Not found";
            }else{
                outputformat = fullName.getFullName().concat("=").concat(phoneNumber);
            }
            
            outputList.add(outputformat);
        }
        
        for(String output: outputList) {
            System.out.println(output);
        }
        
        scanner.close();
    }

}

class Name {
    String firstName;
    String lastName;
    
    public Name(String firstName) {
        this.firstName = firstName;
        this.lastName = null;
    }
    
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    public String getFullName() {
        if(getLastName() != null) {
            return getFirstName().concat(" ").concat(getLastName());
        }else {
            return getFirstName();
        }
        
    }
    
    
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Name other = (Name) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
    }
    
    
}

