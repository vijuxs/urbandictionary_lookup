
/***

  @@author viju
  @@licence http://www.wtfpl.net
  Date: 22 April 2021

**/

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Entry {

  String definition;
  String permalink;

  @JsonProperty("thumbs_up")
  int thumbsUp;
  @JsonProperty("thumbs_down")
  int thumbsDown;
  @JsonProperty("sound_urls")
  List<String> soundUrls;
  String author;
  String word;
  @JsonProperty("defid")
  long defId;
  @JsonProperty("current_vote")
  String currentVote;
  String example;
  @JsonProperty("written_on")
  String writtenOn;

  public String getDefinition() {
    return this.definition;
  }

  public void setDefinition(String definition) {
    this.definition = definition;
  }

  public String getPermalink() {
    return this.permalink;
  }

  public void setPermalink(String permalink) {

    this.permalink = permalink;
  }

  public int thumbsUp() {
    return this.thumbsUp;
  }

  public void setThumbsUp(int thumbsUp) {
    this.thumbsUp = thumbsUp;
  }

  public List<String> getSoundUrls() {
    return this.soundUrls;
  }

  public void setSoundUrls(List<String> soundUrls) {
    this.soundUrls = soundUrls;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getWord() {
    return this.word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public long getDefId() {
    return this.defId;
  }

  public void setDefId(long defId) {
    this.defId = defId;
  }
  public String getCurrentVote() {
    return this.currentVote;
  }

  public void setCurrentVote(String currentVote) {
    this.currentVote = currentVote;
  }

  public String getExample() {
    return this.example;
  }

  public void setExample(String example) {
    this.example = example;
  }

  public String getWrittenOn() {
    return this.writtenOn;
  }

  public void setWrittenOn(String writtenOn) {
    this.writtenOn = writtenOn;
  }
}

class EntryList {
  @JsonProperty("list")
  List<Entry> entries;

  public List<Entry> getEntries() {
    return this.entries;
  }

  public void setEntries(List<Entry> entries) {
    this.entries = entries;
  }
}
