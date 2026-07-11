
package finalchance.demo.entity;

import java.util.List;

public class Insight {
    private String sentiment;
    private List<String> tags;
    private String reflection;

    // getters/setters
    public String getSentiment() { return sentiment; }
    public void setSentiment(String sentiment) { this.sentiment = sentiment; }
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
    public String getReflection() { return reflection; }
    public void setReflection(String reflection) { this.reflection = reflection; }
}