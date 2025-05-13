package de.bsi.udemyai4business.chat.model;

public class EncryptedText {

    private String text;
    private String encryptedText;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEncryptedText() {
        return encryptedText;
    }

    public void setEncryptedText(String encryptedText) {
        this.encryptedText = encryptedText;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        EncryptedText that = (EncryptedText) o;
        return text.equals(that.text) && encryptedText.equals(that.encryptedText);
    }

    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + encryptedText.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "EncryptedText{" +
                "text='" + text + '\'' +
                ", encryptedText='" + encryptedText + '\'' +
                '}';
    }

}
