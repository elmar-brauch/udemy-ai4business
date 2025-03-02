package de.bsi.udemyai4business.chat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("secret")
class ChatServiceTest {

    @Test
    void askQuestionWithoutContext(@Autowired BasicChatService aiChat) {
        var question = "Welche Firma organisiert das beste AI Barcamp in Bonn?";

        var answer = aiChat.ask(question);

        checkChat(question, answer);
    }

    @Test
    void askQuestionWithSystemPrompt(@Autowired SystemPromptChatService aiChat) {
        var question = "Welche Firma organisiert das beste AI Barcamp in Bonn?";

        var answer = aiChat.ask(question);

        checkChat(question, answer);
    }

    @Test
    void chatWithMemory(@Autowired MemoryChatService aiChat) {
        var name = "Rumpelstilzchen";

        var message1 = "Mein Name ist %s.".formatted(name);
        var answer = aiChat.chat(message1);
        checkChat(message1, answer);

        var message2 = "Wie heiße ich?";
        answer = aiChat.chat(message2);
        checkChat(message2, answer);

        assertTrue(answer.contains(name));
    }

    @Test
    void chatWithTool(@Autowired ToolChatService aiChat) {
        var question = "Verschlüssele bitte den Text 'Geheimnis'!";
        var answer = aiChat.ask(question);
        checkChat(question, answer);

        assertTrue(answer.contains("g€h€_mn_s"));
    }

    private static final String SALES_DIALOG = """
            Kunde: Guten Tag, mein Name ist Max Barcamp aus Bonn. Ich bin auf der Suche nach einem neuen Smartphone. Es sollte gute Leistung haben, aber auch nicht zu teuer sein.
            Verkäufer: Hallo Max! Welche Funktionen sind Ihnen besonders wichtig? Kamera, Akku oder Prozessorleistung?
            Kunde: Die Kamera und der Akku sind mir wichtig. Ich nutze das Handy oft für Fotos und arbeite den ganzen Tag damit.
            Verkäufer: Da habe ich das perfekte Modell für Sie! Es hat eine tolle Kamera, einen langlebigen Akku und einen schnellen Prozessor. Möchten Sie mehr darüber erfahren?
            Kunde: Ja, wie viel kostet es?
            Verkäufer: Es kostet 499 Euro, aber aktuell gibt es 10% Rabatt. Wir bieten auch eine Finanzierungsoption an, falls das für Sie interessant ist.
            Kunde: Das klingt gut! Was muss ich tun, um das Angebot zu nutzen?
            Verkäufer: Ich benötige noch einige Daten, um die Bestellung abzuschließen. Darf ich Ihre Adresse und Telefonnummer aufnehmen?
            Kunde: Natürlich. Ich wohne in Landgrabenweg 151 und meine Telefonnummer ist 0151 456789.
            Verkäufer: Danke! Und Ihre E-Mail-Adresse für die Bestätigung?
            Kunde: max.barcamp@telekom.de.
            Verkäufer: Die Postleitzahl fehlt noch.
            Kunde: Die ist 53111.
            Verkäufer: Super, danke! Ich bereite Ihre Bestellung vor und sende Ihnen eine Bestätigung. Möchten Sie noch Zubehör oder eine Garantie hinzufügen?
            Kunde: Nein, das reicht erstmal.
            Verkäufer: Alles klar! Ihr Smartphone ist reserviert. Sie erhalten gleich eine E-Mail mit den Details. Vielen Dank für den Kauf, Max!
            Kunde: Danke, ich freue mich schon darauf!
            Verkäufer: Viel Spaß mit Ihrem neuen Handy!
            """;

    @Test
    void identifyCustomerData(@Autowired ParsingChatService aiChat) {
        var customerData = aiChat.identifyCustomer(SALES_DIALOG);

        checkChat(SALES_DIALOG.substring(0, 100) + "...", customerData);

        assertEquals("Max", customerData.getFirstName());
        assertEquals("Barcamp", customerData.getLastName());
        assertEquals("max.barcamp@telekom.de", customerData.getEmail());
        assertEquals("0151 456789", customerData.getPhone());
        assertEquals("Landgrabenweg", customerData.getStreetName());
        assertEquals("151", customerData.getStreetNumber());
        assertEquals("53111", customerData.getZipCode());
        assertEquals("Bonn", customerData.getCity());
    }

    private void checkChat(String userMessage, Object answer) {
        Logger log = LoggerFactory.getLogger(ChatServiceTest.class);
        log.info("\nUSER: {}\nAI RESPONSE: {}", userMessage, answer);

        assertNotNull(answer);
    }

}