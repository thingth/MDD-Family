package mmm.mddfamily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListData
{
    public static HashMap<String, List<String>> getData() {

        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> cricketPlayers = new ArrayList<String>();
        cricketPlayers.add("");
        cricketPlayers.add("");
        cricketPlayers.add("");
        cricketPlayers.add("");
        cricketPlayers.add("");
        expandableListDetail.put("", cricketPlayers);

        return expandableListDetail;

    }
}
