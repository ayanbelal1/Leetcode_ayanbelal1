import java.util.*;

class Solution {
    private static class Event {
        String type;
        int time;
        String content;
        int idx;

        Event(String type, int time, String content, int idx) {
            this.type = type;
            this.time = time;
            this.content = content;
            this.idx = idx;
        }
    }

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        List<Event> evs = new ArrayList<>();
        for (int i = 0; i < events.size(); ++i) {
            List<String> e = events.get(i);
            String type = e.get(0);
            int t = Integer.parseInt(e.get(1));
            String content = e.get(2);
            evs.add(new Event(type, t, content, i));
        }
        evs.sort((a, b) -> {
            if (a.time != b.time) return Integer.compare(a.time, b.time);
            if (!a.type.equals(b.type)) {
                return a.type.equals("OFFLINE") ? -1 : 1;
            }
            return Integer.compare(a.idx, b.idx);
        });

        int[] mentions = new int[numberOfUsers];
        boolean[] online = new boolean[numberOfUsers];
        Arrays.fill(online, true); 
        int[] nextOnlineAt = new int[numberOfUsers]; 

        int curTime = -1;
        for (int i = 0; i < evs.size(); ++i) {
            Event ev = evs.get(i);
            if (ev.time != curTime) {
                curTime = ev.time;
                for (int u = 0; u < numberOfUsers; ++u) {
                    if (!online[u] && nextOnlineAt[u] != 0 && nextOnlineAt[u] <= curTime) {
                        online[u] = true;
                        nextOnlineAt[u] = 0;
                    }
                }
            }

            if (ev.type.equals("OFFLINE")) {
                int uid = Integer.parseInt(ev.content);
                online[uid] = false;
                nextOnlineAt[uid] = ev.time + 60; 
            } else { 
                String ment = ev.content;
                if (ment.equals("ALL")) {
                    for (int u = 0; u < numberOfUsers; ++u) mentions[u]++;
                } else if (ment.equals("HERE")) {
                    for (int u = 0; u < numberOfUsers; ++u) if (online[u]) mentions[u]++;
                } else {
                   
                    String[] tokens = ment.split("\\s+");
                    for (String tok : tokens) {
                        if (tok.startsWith("id")) {
                            int uid = Integer.parseInt(tok.substring(2));
                            mentions[uid]++;
                        }
                    }
                }
            }
        }

        return mentions;
    }
}
