package tech.fuge.www.forgotheadfirstandroid.model;

/**
 * Created by Lin Zongfu on 2017/6/25.
 */

public class Workout {
    private String name;
    private String description;

    public static final Workout[] workouts = {
            new Workout("task1", "新华社北京6月24日电 6月24日6时许，四川阿坝州茂县叠溪镇新磨村发生山体高位垮塌，造成40余户农房、100余人被掩埋，岷江支流松坪沟河道堵塞2公里。\n" +
                    "\n" +
                    "　　灾害发生后，党中央、国务院高度重视。中共中央总书记、国家主席、中央军委主席习近平立即作出重要指示，要求四川省全力组织搜救被埋人员，尽最大努力减少人员伤亡、防范次生灾害发生，并妥善做好失踪人员亲属和受灾人员的安抚安置工作。国务院要派工作组前往指导抢险救援，慰问受灾群众。目前，已进入主汛期，多地出现较大降雨，各地和有关部门要加强灾害防范，排查各种隐患，确保人民群众生命财产安全。"),
            new Workout("task2", "　　中共中央政治局常委、国务院总理李克强作出批示，要求全力组织搜救，尽力减少人员伤亡，并抓紧排查周边地质灾害隐患，尽快转移受威胁群众，防止发生次生灾害。要查清垮塌原因，妥为善后处置。国家减灾委要督促各地切实加强各类灾害防范和安全生产工作。"),
            new Workout("task2", "根据习近平指示和李克强要求，国务院即派工作组赶赴现场指导抢险救援工作。四川省委、省政府主要负责同志紧急赶赴现场开展救援工作。四川省、阿坝州已启动地质灾害Ⅰ级应急响应。目前，抢险救援工作正在紧张有序进行。")
    };

    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
