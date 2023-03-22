import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PestControlSystem {
    Garden garden;
    Map<String, String> pestControlMethods;

    public PestControlSystem(Garden garden) {
        this.garden = garden;
        pestControlMethods = new HashMap<>();
    }

    public List<Insect> detectPests() {
        List<Insect> pests = new ArrayList<>();
        for (Insect insect : garden.insects) {
            if (insect.getDamage() > 0) {
                pests.add(insect);
            }
        }
        return pests;
    }

    public void applyPestControl(String method, Insect insect) {
        // Implement logic to apply pest control
    }

    public void addPestControlMethod(String name, String description) {
        pestControlMethods.put(name, description);
    }

    public void removePestControlMethod(String name) {
        pestControlMethods.remove(name);
    }
}