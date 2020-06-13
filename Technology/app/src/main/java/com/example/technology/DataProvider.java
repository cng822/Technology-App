package com.example.technology;

import android.content.Intent;

import com.example.technology.R;
import com.example.technology.Technology;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {
    static String[] products = {"Blackberry 10" , "iPhone 4" ,"Google Nexus 1", "Nokia 7230",
    "OPPO R11", "Sony Xperia 1", "LG Smart Watch", "MacBook Air 2018", "MackBook Pro", "Apple Watch Series 1"
    ,"Apple Watch Series 3", "Asus Laptop", "Fitbit Charge 4", "Galaxy Watch", "Garmin Fenix", "Fitbit Inspire",
    "iPhone 8", "Fitbit Kids", "iPhone 11", "Lenovo Laptop", "OnePlus", "Windows Surface", "Venu",
    "Vivomove", "iPhone XR", "MacBook Air 2019", "HP Elitebook", "Surface 2", "MacBook Pro 2016",
    "Asus Tablet/Laptop"};

    static String[] prices = {"599","499","285","297","769", "1199", "449", "1949", "2079", "450",
            "550", "480","269", "419", "1099", "165", "499", "139", "1449", "799", "599", "729",
            "629", "549", "1249", "1799", "689", "2679","2349", "776"};

    static int[] categoryNumbers = {1,1,1,1,1,1,3,2,2,3,3,2,3,3,3,3,1,3,1,2,1,2,3,3,1,2,2,2,2,2};

    static int[] covers = {R.drawable.blackberry_1, R.drawable.iphone4_1, R.drawable.nexus_1,
    R.drawable.nokia_1, R.drawable.oppor11_1, R.drawable.sony_1, R.drawable.lgwatch_1,
    R.drawable.macbookair_1,R.drawable.macbookpro_1,R.drawable.series1_3, R.drawable.series3_1,
    R.drawable.asus_1, R.drawable.charge_1, R.drawable.galaxy_1, R.drawable.garmin_1,
    R.drawable.inspire__1, R.drawable.iphone8_1, R.drawable.kids_1, R.drawable.iphone11_1,
    R.drawable.lenovo_1, R.drawable.oneplus_1, R.drawable.surface_1, R.drawable.venu_1,
            R.drawable.vivomove_1, R.drawable.xr_1, R.drawable.air_3, R.drawable.hp_1,
    R.drawable.surface2_1, R.drawable.pro_1, R.drawable.tablet_1};

    static String[] descriptions = {
            "The Blackberry 10 has better performance in the same familiar package. A familiar " +
                    "design inclusive of the beloved classic navigation keys and keyboard, with " +
                    "the speed and powerful performance of BlackBerry 10.",
            "The iPhone 4 has a 3.50-inch touchscreen display with a resolution of 640x960 pixels " +
                    "at a pixel density of 326 pixels per inch (ppi). Apple iPhone 4 is powered " +
                    "by an one-core processor. It comes with 512MB of RAM.",
            "The Google Nexus is runs the Android operating system. Google manages the design, " +
                    "development, marketing, and support of this devices, but some development " +
                    "and all manufacturing were carried out by partnering with original equipment " +
                    "manufacturers (OEMs).",
            "The Nokia 7230 is a stylish, well-priced 3G slider phone that has a good quality of " +
                    "preloaded apps and a 3.2MP camera. ",
            "The OPPO R11 showcases groundbreaking dual 20MP with enhanced effects and unprecedented" +
                    " pictorial clarity.",
            "The Sony Xperia is a very capable and good looking phone which provides the user with " +
                    "a great battery life, decent camera and a big screen in an easy to hold body.",
            "The LG Smart Watch has long-lasting battery that ensures  everything you need is " +
                    "always accessible when you need it most. It's dust and water resistant as well.",
            "The 13-inch MacBook Air features 8GB of memory, a fifth-generation Intel Core " +
                    "processor, Thunderbolt 2, great built-in apps and all-day battery life. It’s " +
                    "thin, light and durable enough to take everywhere you go — and powerful " +
                    "enough to do everything. ",
            "MacBook Pro elevates the notebook to a whole new level of performance and " +
                    "portability. Wherever your ideas take you, you'll get there faster than " +
                    "ever with high-performance processors and memory, " +
                    "blazing-fast storage and more.",
            "The Apple Watch Series 1 is a fitness watch with a built-in heart rate monitor. It " +
                    "was designed to be paired with an iPhone so that the phone can stay in the " +
                    "wearer's pocket and the apps and notifications can be worn on the wrist.",
            "The Apple Watch Series 3 features mobile service. So you can leave your phone " +
                    "behind and still make calls, get text messages and stream your music.",
            "There's a series of handy ASUS utility apps to boost productivity including Quick Key " +
                    "- for one-tap automation of complex keyboard sequences - along with " +
                    "Handwriting, Number Key and Office Xpert. ",
            "Take your goals further with this swimproof tracker packed with built-in GPS, " +
                    "innovative heart rate features, Fitbit Pay and more.",
            "The Samsung Galaxy Watch has been designed with all lifestyles in mind. With a " +
                    "timeless traditional watch design, the Galaxy Watch is for all occasions – " +
                    "and with an extended battery life* and 50m (5ATM) water resistance*, you can " +
                    "now go for longer.",
            "Styled for a trim, comfortable fit on smaller wrists, the 1.2 inch fēnix 6S is the " +
                    "multisport GPS watch for athletes and adventurers who want to do more, not wear " +
                    "more.",
            "Fitbit Inspire HR is a friendly heart rate & fitness tracker for every day that helps " +
                    "you build healthy habits. This encouraging companion motivates you to reach " +
                    "your health, workout features, calorie burn tracking, goal celebrations, " +
                    "and sleep stages.",
            "The iPhone 8 includes a 4.7-inch display, while the iPhone 8 Plus features a larger " +
                    "5.5-inch display. Both displays were " +
                    "designed to adapt color temperature and intensity to the ambient light in a " +
                    "room for a more natural, paper-like viewing experience.",
            "Make fitness fun for kids and their families. With lots of cool games and rewards for " +
                    "healthy habits, kids have never been more inspired to get up and get moving.",
            "Shoot 4K video, beautiful portraits and sweeping landscapes with the all-new " +
                    "dual-camera system. Capture your best low-light photos with Night mode. " +
                    "See true-to-life colour in your photos, videos and games on the 6.1-inch " +
                    "Liquid Retina display.",
            "The ThinkPad E590's security features help your SMB take control. The optional " +
                    "fingerprint reader adds secure biometric authentication, while the discrete " +
                    "trusted platform module (TPM) encrypts data at the hardware level. We take " +
                    "care of security so you can take care of business.",
            "Built with remarkable precision, the OnePlus 8 is designed to impress, with a " +
                    "brilliant contoured design that feels great in the hand.",
            "Starting at just 544 grams (not including Type Cover*), and featuring a new, " +
                    "virtually edge-to-edge 10.5 inch touchscreen display.",
            "Find a time and a place for every part of your active life with Venu. This GPS " +
                    "smartwatch features a bright, beautiful display and a battery life of up to " +
                    "5 days, so you can spend more time doing the activities you love.",
            "The Vivomove Style smartwatch combines the traditional look of an analog watch with " +
                    "the essential smart features you count on to keep up with your busy life. ",
            "iPhone XR features the most advanced LCD in a smartphone — a 6.1-inch Liquid Retina " +
                    "display with industry-leading colour accuracy and an innovative backlight " +
                    "design that allows the screen to stretch into the corners.",
            "The incredibly thin and light MacBook Air is now more powerful than ever. It features " +
                    "a brilliant Retina display, new Magic Keyboard, Touch ID, processors with up " +
                    "to twice the performance, faster graphics and double the storage capacity.",
            "HP EliteBook 840 is a laptop with a 14.00-inch display. It is powered by a Core i5 " +
                    "processor and it comes with 8GB of RAM. The HP EliteBook 840 packs 256GB of " +
                    "HDD storage. Connectivity options include Wi-Fi 802.11 a/b/g.",
            "Get powerhouse performance and amazing graphics with the new Surface Book 2, a " +
                    "robust laptop, tablet, and portable studio in one with up to 17 hours of " +
                    "battery life and 2 times more power than before.",
            "The MacBook Pro Core i7 2.9 15-Inch (Late 2016 Retina Display, Touch Bar, Four " +
                    "Thunderbolt 3 Ports) features a 14 nm, 6th Generation Skylake 2.9 GHz Intel " +
                    "Core i7 processor (6920HQ), with four independent processor cores on a single " +
                    "silicon chip",
            "This is a convertible laptop that features the extremely narrow ASUS NanoEdge bezel, " +
                    "allowing its 14-inch Full HD display to fit into a typical 13-inch laptop " +
                    "frame. The slim and lightweight VivoBook Flip 14 is designed to suit any " +
                    "occasion."
    };

    public static List<Technology> generateData() {
        ArrayList<Technology> techList = new ArrayList<Technology>();
        for (int i = 0; i < products.length; i++) {
            String category = "";
            String productName = products[i];
            String price = prices[i];
            String description = descriptions[i];
            int categoryNumber = categoryNumbers[i];
            int cover = covers[i];
            if (categoryNumber == 1) {
                category = "Phones";
                Technology aPhone = new Technology.Phones(productName, category, cover, price, description) {
                };
                techList.add(aPhone);
            } else if (categoryNumber == 2){
                category = "Laptops";
                Technology aLaptop = new Technology.Laptops(productName, category, cover, price,description) {
                };
                techList.add(aLaptop);
            } else if (categoryNumber == 3) {
                category = "Smart Watches";
                Technology aWatch = new Technology.SmartWatches(productName, category, cover, price, description);
                techList.add(aWatch);
            }
        }

        return techList;
    }
}
