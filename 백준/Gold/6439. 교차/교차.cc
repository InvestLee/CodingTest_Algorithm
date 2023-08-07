#include<stdio.h>
int f(long long x1,long long y1,long long x2,long long y2,long long x3,long long y3)
{
    long long a=(x1*y2+x2*y3+x3*y1)-(y1*x2+y2*x3+y3*x1);
    if(a>0) return 1;
    else if(a<0) return -1;
    else return 0;
}
bool g(long long x1,long long y1,long long x2,long long y2,long long x3,long long y3,long long x4,long long y4)
{
    if(f(x1,y1,x2,y2,x3,y3)*f(x1,y1,x2,y2,x4,y4)<=0&&f(x3,y3,x4,y4,x1,y1)*f(x3,y3,x4,y4,x2,y2)<=0)
    {
        if((x1>x3&&x1>x4&&x2>x3&&x2>x4)||(x3>x1&&x3>x2&&x4>x1&&x4>x2)) return 0;
        else if((y1>y3&&y1>y4&&y2>y3&&y2>y4)||(y3>y1&&y3>y2&&y4>y1&&y4>y2)) return 0;
        else return 1;
    }
    else return 0;
}
int main()
{
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++)
    {
        long long x1,y1,x2,y2,a,b,c,d,t;
        scanf("%lld%lld%lld%lld%lld%lld%lld%lld",&a,&b,&c,&d,&x1,&y1,&x2,&y2);
        if(x1>x2){t=x1;x1=x2;x2=t;}
        if(y1>y2){t=y1;y1=y2;y2=t;}
        if(g(a,b,c,d,x1,y1,x1,y2)||g(a,b,c,d,x1,y2,x2,y2)||g(a,b,c,d,x2,y2,x2,y1)||g(a,b,c,d,x2,y1,x1,y1)||(x1<=a&&a<=x2&&y1<=b&&b<=y2)||(x1<=c&&c<=x2&&y1<=d&&d<=y2)) printf("T\n");
        else printf("F\n");
    }
}