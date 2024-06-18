import java.util.*;
class user{
    String name;
    int user_id;
    int phone;
    
    List<Policy> policies;
    public user(String name,int user_id,int phone){
        this.name=name;
        this.user_id=user_id;
        this.phone=phone;
        policies=new ArrayList<>();
    }
    public int buypolicy(Policy p,String s,String s2)
    {
        double amount = p.amount;
        double rates = p.rates;
        double amt=amount*rates;
        System.out.println("The amount to be paid for the policy is: "+amt+"\nClick 1 to pay and 0 to cancel");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n==1)
        {
            System.out.println("You have Successfully purchased the policy");
            policies.add(p);
            p.s_date=s;
            p.e_date=s2;
            return 1;
        }
        else
        {
            System.out.println("You have cancelled");
            return 0;
        }
    }
    public void displaypurchasedpolicy()
    {
        int i=1;
        for(Policy po:policies)
        {
            System.out.println(po.getClass().getName()+"\nName: "+po.name+"\nrates: "+po.rates+"\ncoverage_type: "+po.coverage_type+"\namount: "+po.amount+"\nduration: "+po.duration+"\nrating : "+po.rating);
            System.out.println("start date: 14/3/2024\nend date:14/9/2024");
            i++;
        }
    }
    public void checkrenewal()
    {
        for(Policy po:policies)
        {
            int n = Integer.parseInt(po.s_date);
            int dur = n+600;
            if(dur>(Integer.parseInt(po.e_date)))
            {
                System.out.println("User: "+user_id+"Your policy has been expired");
            }

        }
    }
}
class management{
    List<user> users = new ArrayList<>();
    List<Policy> policy = new ArrayList<>();
    public void addpolicy(Policy p)
    {
        policy.add(p);
    }
    public void adduser(user u)
    {
        users.add(u);
    }
    public void displaypolicy()
    {
        int i=1;
        for(Policy po:policy)
        {
            System.out.println("Policy "+po+"\nName: "+po.name+"\nrates: "+po.rates+"\ncoverage_type: "+po.coverage_type+"\namount: "+po.amount+"\nduration: "+po.duration+"\nrating : "+po.rating);
            i++;
        }
    }
    

}
class Policy{
    String name;
    int policy_id;
    int rates;
    String coverage_type;
    float amount;
    int duration;
    float rating;
    String s_date;
    String e_date;
    public Policy(String name,int policy_id,int rates,String type,float amount,int duration,float rating)
    {
        this.name=name;
        this.policy_id=policy_id;
        this.rates=rates;
        coverage_type=type;
        this.amount=amount;
        this.duration=duration;
        this.rating=rating;
    }
}
class insurance{
    public static void main(String[] args)
    {
        user user1 = new user("pranav",1234,9090);
        user user2 = new user("jadhav",1235,9091);
        Policy policy1 = new Policy("bike1",1,2,"half",1000,6,3);
        Policy policy2 = new Policy("bike2",2,3,"half",1500,12,4);
        management m1 = new management();
        m1.addpolicy(policy1);
        m1.addpolicy(policy2);
        m1.adduser(user1);
        m1.displaypolicy();
        int n=user1.buypolicy(policy2,"140124","130524");
        if(n==1)
        {
            System.out.println("The purchased policy is: ");
            user1.displaypurchasedpolicy();
        }
        int n2=user2.buypolicy(policy1,"140124","140824");
        if(n2==1)
        {
            System.out.println("The purchased policy is: ");
            user2.displaypurchasedpolicy();
        }
        user1.checkrenewal();
        user2.checkrenewal();
    }
}