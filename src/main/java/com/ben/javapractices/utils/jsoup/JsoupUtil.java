package com.ben.javapractices.utils.jsoup;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;

import com.ben.javapractices.utils.htmlencodedecode.HtmlManipulator;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JsoupUtil {

    private final String BODY_OPEN = "<body>";

    private final String BODY_CLOSE = "</body>";

    private final String STYLE_ATTRIBUTE = "style";

    private final String REQUIRED_TAG = "p";

    public String cleanInput(String htmlInput, String allowedTag, String... allowedAttributes) {
        String cleanedInput = "";

        if (allowedTag == null) {
            cleanedInput = Jsoup.clean(htmlInput, Whitelist.none());
        } else if (allowedTag != null && allowedAttributes != null) {
            Whitelist w = new Whitelist();
            cleanedInput = Jsoup.clean(htmlInput, w.addAttributes(allowedTag, allowedAttributes));
        }

        return cleanedInput;
    }

    public boolean isInputStringValidForXSS(String inputString) {
        boolean result;

        if (inputString.isEmpty()) {
            result = true;
        } else {
            String htmlString;

            String replacedInput = inputString.replaceAll("\\\\x", "%");
            String decodedInput = URLDecoder.decode(replacedInput, StandardCharsets.UTF_8);
            htmlString = HtmlManipulator.replaceHtmlEntities(decodedInput);

            Document document = Jsoup.parse(htmlString);
            String documentString = document.toString();
            String documentStringTrimmed = trimTrailingWhiteSpaces(documentString).replace("  ", " ");
            String cleanedInput = Jsoup.clean(htmlString, Whitelist.relaxed().addAttributes(":all", "style"));
            String cleanedInputPlain = Jsoup.parse(cleanedInput).toString();
            String cleanedInputPlainTrimmed = trimTrailingWhiteSpaces(cleanedInputPlain).replace("  ", " ");

            result = documentStringTrimmed.equals(cleanedInputPlainTrimmed);
        }

        return result;
    }

    public boolean isHtmlStringValid(String htmlString) {
        boolean result = true;

        Document document = Jsoup.parseBodyFragment(htmlString);
        String textOfDocument = document.text();
        if (!textOfDocument.equals(htmlString)) {
            List<Element> tagList = document.body().children().select("*");
            List<Element> pTagList = document.select(REQUIRED_TAG);
            boolean areTagsAllowed = areTagsAllowed(htmlString, tagList);
            boolean areAttributesAllowed = areAttributesAllowed(pTagList);
            result = areTagsAllowed && areAttributesAllowed;
        }

        return result;
    }

    private boolean areAttributesAllowed(List<Element> pTagList) {
        boolean result = true;
        if (!pTagList.isEmpty()) {
            for (Element pTag : pTagList) {
                List<Attribute> attributes = pTag.attributes().asList();
                if (!attributes.isEmpty()) {
                    for (Attribute attribute : attributes) {
                        if (!STYLE_ATTRIBUTE.equals(attribute.getKey())) {
                            result = false;
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }

    private boolean areTagsAllowed(String htmlString, List<Element> tagList) {
        boolean result = true;
        if (!tagList.isEmpty()) {
            for (Element tag : tagList) {
                if (!REQUIRED_TAG.equals(tag.tagName())) {
                    result = false;
                }
            }
        } else if (htmlString.contains(BODY_OPEN) && htmlString.contains(BODY_CLOSE)) {
            result = false;
        }

        return result;
    }

    private String trimTrailingWhiteSpaces(String htmlString) {
        String[] lines = htmlString.split("\n");

        StringBuilder stringBuilder = new StringBuilder();

        for (String line : lines) {
            String trimmedLine = line.replaceAll("\\s+$", "");
            stringBuilder.append(trimmedLine);
        }

        return stringBuilder.toString();
    }

}
