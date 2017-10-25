package szakdolgozat.Client;

//Class that contains the properties of a csv file.

public class Csv {
    private final int id;
    private final String name;
    private final int owner_id;
    private final String owner_name;
    private final int task_id;
    private boolean is_factorized;
    private boolean is_normalized;
    private boolean is_classified;
    private boolean is_feature_selected;
    
    public Csv(int id, String name, int owner_id, String owner_name, int task_id, boolean is_fact, boolean is_norm, boolean is_class, boolean is_fs){
        this.id = id;
        this.name = name;
        this.owner_id = owner_id;
        this.owner_name = owner_name;
        this.task_id = task_id;
        
        this.is_factorized = is_fact;
        this.is_normalized = is_norm;
        this.is_classified = is_class;
        this.is_feature_selected = is_fs;
    }
    
    public int getID(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public int getOwnerID(){
        return owner_id;
    }
    
    public String getOwnerName(){
        return owner_name;
    }
    
    public int getTaskID(){
        return task_id;
    }
    
    public boolean isFactorized(){
        return is_factorized;
    }
    
    public boolean isNormalized(){
        return is_normalized;
    }
    
    public boolean isFeatureSelected(){
        return is_feature_selected;
    }
    
    public boolean isClassified(){
        return is_classified;
    }
    
    public void setFactorized(boolean value){
        is_factorized = value;
    }
    
    public void setNormalized(boolean value){
        is_normalized = value;
    }
    
    public void setFeatureSelected(boolean value){
        is_feature_selected = value;
    }
    
    public void setClassified(boolean value){
        is_classified = value;
    }
}
