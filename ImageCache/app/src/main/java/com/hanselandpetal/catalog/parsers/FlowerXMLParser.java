package com.hanselandpetal.catalog.parsers;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.hanselandpetal.catalog.model.Flower;

public class FlowerXMLParser {

	public static List<Flower> parseFeed(String content) {
		
		try {
			
		    boolean inDataItemTag = false;
		    String currentTagName = "";
		    Flower flower = null;
		    List<Flower> flowerList = new ArrayList();

		    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		    XmlPullParser parser = factory.newPullParser();
		    parser.setInput(new StringReader(content));

		    int eventType = parser.getEventType();

		    while (eventType != XmlPullParser.END_DOCUMENT) {

		        switch (eventType) {
		            case XmlPullParser.START_TAG:
		                currentTagName = parser.getName();
		                if (currentTagName.equals("product")) {
		                    inDataItemTag = true;
		                    flower = new Flower();
		                    flowerList.add(flower);
		                }
		                break;

		            case XmlPullParser.END_TAG:
		                if (parser.getName().equals("product")) {
		                    inDataItemTag = false;
		                }
		                currentTagName = "";
		                break;

		            case XmlPullParser.TEXT:
		                if (inDataItemTag && flower != null) {

                            int idNum = 0;

                            if (currentTagName == "productId"){
                                idNum = 0;
                            }
                            else if (currentTagName == "name"){
                                idNum = 1;
                            }
                            else if (currentTagName == "instructions"){
                                idNum = 2;
                            }
                            else if (currentTagName == "category"){
                                idNum = 3;
                            }
                            else if (currentTagName == "price"){
                                idNum = 4;
                            }
                            else if (currentTagName == "photo"){
                                idNum = 5;
                            }

		                    switch (idNum) {
		                        case 1:
		                            flower.setProductId(Integer.parseInt(parser.getText()));
		                            break;
		                        case 2:
		                        	flower.setName(parser.getText());
		                        	break;
		                        case 3:
		                            flower.setInstructions(parser.getText());
		                            break;
                                case 4 :
		                            flower.setCategory(parser.getText());
		                            break;
		                        case 5 :
		                        	flower.setPrice(Double.parseDouble(parser.getText()));
		                            break;
		                        case 6 :
		                        	flower.setPhoto(parser.getText());
		                        default:
		                            break;
		                    }
		                }
		                break;
		        }

		       eventType = parser.next();

		    }

		    return flowerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 

		
	}
	
}
