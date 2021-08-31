## 优化流程
v1
    
    抽取独立函数，封装到对应类 {@link Rental#getChange()}

V2
    
    移除多余临时变量
    用查询替换临时变量
    {@link Customer#getTotalAmount(),Customer#getFrequentRenterPoints()}

V3

    最好不要在另一个对象的属性基础上运用Switch语句。如果不得不使用，也应该在对象自己的数据上使用，而不是在别人的数据室使用
    只在对应对象操作对应数据变量

V4
    
    解耦抽象出公共操作，为扩展做支撑（使用设计模式对多变，业务流程统一的操作进行抽象）