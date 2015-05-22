package rsantillanc.contactme.model;

/**
 * Created by RenzoD on 22/05/2015.
 */
public class NavItemModel {

    private String label;
    private int icon;


    public NavItemModel(String label, int icon) {
        this.label = label;
        this.icon = icon;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
