package net.minecraft.server;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerSelector {

    private static final Pattern a = Pattern.compile("^@([parf])(?:\\[([\\w=,-]*)\\])?$");
    private static final Pattern b = Pattern.compile("\\G(-?\\w*)(?:$|,)");
    private static final Pattern c = Pattern.compile("\\G(\\w{1,2})=(-?\\w+)(?:$|,)");

    public static EntityPlayer getPlayer(ICommandListener icommandlistener, String s) {
        EntityPlayer[] aentityplayer = getPlayers(icommandlistener, s);

        return aentityplayer != null && aentityplayer.length == 1 ? aentityplayer[0] : null;
    }

    public static String getPlayerNames(ICommandListener icommandlistener, String s) {
        EntityPlayer[] aentityplayer = getPlayers(icommandlistener, s);

        if (aentityplayer != null && aentityplayer.length != 0) {
            String[] astring = new String[aentityplayer.length];

            for (int i = 0; i < astring.length; ++i) {
                astring[i] = aentityplayer[i].getLocalizedName();
            }

            return CommandAbstract.a((Object[]) astring);
        } else {
            return null;
        }
    }

    public static EntityPlayer[] getPlayers(ICommandListener icommandlistener, String s) {
        Matcher matcher = a.matcher(s);

        if (matcher.matches()) {
            Map map = h(matcher.group(2));
            String s1 = matcher.group(1);
            int i = c(s1);
            int j = d(s1);
            int k = f(s1);
            int l = e(s1);
            int i1 = g(s1);
            int j1 = EnumGamemode.NONE.a();
            ChunkCoordinates chunkcoordinates = icommandlistener.b();

            if (map.containsKey("rm")) {
                i = MathHelper.a((String) map.get("rm"), i);
            }

            if (map.containsKey("r")) {
                j = MathHelper.a((String) map.get("r"), j);
            }

            if (map.containsKey("lm")) {
                k = MathHelper.a((String) map.get("lm"), k);
            }

            if (map.containsKey("l")) {
                l = MathHelper.a((String) map.get("l"), l);
            }

            if (map.containsKey("x")) {
                chunkcoordinates.x = MathHelper.a((String) map.get("x"), chunkcoordinates.x);
            }

            if (map.containsKey("y")) {
                chunkcoordinates.y = MathHelper.a((String) map.get("y"), chunkcoordinates.y);
            }

            if (map.containsKey("z")) {
                chunkcoordinates.z = MathHelper.a((String) map.get("z"), chunkcoordinates.z);
            }

            if (map.containsKey("m")) {
                j1 = MathHelper.a((String) map.get("m"), j1);
            }

            if (map.containsKey("c")) {
                i1 = MathHelper.a((String) map.get("c"), i1);
            }

            List list;

            if (!s1.equals("p") && !s1.equals("a")) {
                if (!s1.equals("r")) {
                    return null;
                } else {
                    list = MinecraftServer.getServer().getServerConfigurationManager().a(chunkcoordinates, i, j, 0, j1, k, l);
                    Collections.shuffle(list);
                    list = list.subList(0, Math.min(i1, list.size()));
                    return list != null && !list.isEmpty() ? (EntityPlayer[]) list.toArray(new EntityPlayer[0]) : new EntityPlayer[0];
                }
            } else {
                list = MinecraftServer.getServer().getServerConfigurationManager().a(chunkcoordinates, i, j, i1, j1, k, l);
                return list != null && !list.isEmpty() ? (EntityPlayer[]) list.toArray(new EntityPlayer[0]) : new EntityPlayer[0];
            }
        } else {
            return null;
        }
    }

    public static boolean isList(String s) {
        Matcher matcher = a.matcher(s);

        if (matcher.matches()) {
            Map map = h(matcher.group(2));
            String s1 = matcher.group(1);
            int i = g(s1);

            if (map.containsKey("c")) {
                i = MathHelper.a((String) map.get("c"), i);
            }

            return i != 1;
        } else {
            return false;
        }
    }

    public static boolean isPattern(String s, String s1) {
        Matcher matcher = a.matcher(s);

        if (!matcher.matches()) {
            return false;
        } else {
            String s2 = matcher.group(1);

            return s1 == null || s1.equals(s2);
        }
    }

    public static boolean isPattern(String s) {
        return isPattern(s, (String) null);
    }

    private static final int c(String s) {
        return 0;
    }

    private static final int d(String s) {
        return 0;
    }

    private static final int e(String s) {
        return Integer.MAX_VALUE;
    }

    private static final int f(String s) {
        return 0;
    }

    private static final int g(String s) {
        return s.equals("a") ? 0 : 1;
    }

    private static Map h(String s) {
        HashMap hashmap = new HashMap();

        if (s == null) {
            return hashmap;
        } else {
            Matcher matcher = b.matcher(s);
            int i = 0;

            int j;

            for (j = -1; matcher.find(); j = matcher.end()) {
                String s1 = null;

                switch (i++) {
                case 0:
                    s1 = "x";
                    break;

                case 1:
                    s1 = "y";
                    break;

                case 2:
                    s1 = "z";
                    break;

                case 3:
                    s1 = "r";
                }

                if (s1 != null && matcher.group(1).length() > 0) {
                    hashmap.put(s1, matcher.group(1));
                }
            }

            if (j < s.length()) {
                matcher = c.matcher(j == -1 ? s : s.substring(j));

                while (matcher.find()) {
                    hashmap.put(matcher.group(1), matcher.group(2));
                }
            }

            return hashmap;
        }
    }
}
