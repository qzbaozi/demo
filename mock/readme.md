#mock 私有方法

mock UserService 中的私有方法
```

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserServiceTest {
   @Test
    public void testAdd() throws Exception {
        UserService cal = PowerMockito.spy(new UserService());
        PowerMockito.doReturn(2).when(cal,"sumXX", anyInt(), anyInt());
        assertEquals(2, cal.callSumXX(1, 2));
    }
}

```