import Model.BaseData;
import com.yunkuent.sdk.*;
import com.yunkuent.sdk.data.ReturnResult;
import com.yunkuent.sdk.utils.Util;

import java.net.HttpURLConnection;

/**
 * Created by Brandon on 2014/8/6.
 */
public class SDKTester {

    private static EntLibManager mEntLibManager;
    private static EntManager mEntManager;
    private static EntFileManager mFileManager;

    public static void main(String[] args) {
        DebugConfig.PRINT_LOG = true;
//        DebugConfig.LOG_PATH="D://LogPath";//默认在D盘根目录

        //==========================云库企业库操作==========================//
        mEntLibManager = new EntLibManager(OauthConfig.CLIENT_ID, OauthConfig.CLIENT_SECRET);
        //创建云库 1T="1099511627776" 1G＝“1073741824”；
//        deserializeReturn(mEntLibManager.create("ququ", "1073741824", "destroy", "test lib", ""));

        //修改库信息 1T="1099511627776" 1G＝“1073741824”；
//        deserializeReturn(mEntLibManager.set(379619, "中国梦", "9999", "", ""));

        //获取库信息
//        deserializeReturn(mEntLibManager.getInfo(1245337));

        //获取库列表
//        deserializeReturn(mEntLibManager.getLibList(0));

        //获取库授权
//        deserializeReturn(mEntLibManager.bind(1245361,"YunkuJavaSDKDemo",null));

        //取消库授权
//        deserializeReturn(mEntLibManager.unBind("0b7bd4e22c1a9eb8e3ddba2b6c37f6e2"));

        //添加库成员
//        deserializeReturn(mEntLibManager.addMembers(379620,2892,new int[]{125771}));

        //获取某一个库的成员
//        deserializeReturn(mEntLibManager.getMembers(0, 10, 379620));
//
        //查询库成员信息
//        deserializeReturn(mEntLibManager. getMember(4405,MemberType.ACCOUNT,new String[]{"qwdqwdq1"}));

        //批量修改单库中成员角色
//        deserializeReturn(mEntLibManager.setMemberRole(150998,2894,new int[]{4}));

        //从库中删除成员
//        deserializeReturn(mEntLibManager.delMember(150998,new int[]{4}));

        //获取某一个企业分组列表
//        deserializeReturn(mEntLibManager.getGroups(32657));

        //库上添加分组
//        deserializeReturn(mEntLibManager.addGroup(150998,4448,2892));

        //库上删除分组
//        deserializeReturn(mEntLibManager.delGroup(150998,4448));

        //设置分组上的角色
//        deserializeReturn(mEntLibManager.setGroupRole(150998,4448,2894));

        //删除库
//        deserializeReturn(mEntLibManager.destroy("b2013df96cbc23b4b0dd72f075e5cbf7"));


//=======文件操作========//

        // orgClientId orgClientSecret 需要通过 EntLibManager 中 bind 获取库授权获取

        String orgClientId = "";
        String orgClientSecret = "";
        mFileManager = new EntFileManager(orgClientId, orgClientSecret);
        //获取库中文件
        deserializeReturn(mFileManager.getFileList());

        //获取更新列表
//        deserializeReturn(mFileManager.getUpdateList( false, 0));

        //文件更新数量
        //
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE, -1);//昨天
//        Date date = calendar.getTime();

//        deserializeReturn(mFileManager.getUpdateCounts( date.getTime(), System.currentTimeMillis(), false));

        //获取文件(夹)信息
//        deserializeReturn(mFileManager.getFileInfo("p.jpg", EntFileManager.NetType.DEFAULT));

        //通过文件唯一标识获取下载地址
//        deserializeReturn(mFileManager.getDownloadUrlByHash("fe515ef69e56d6b60ecf3ed779c542f1920c3136",false,EntFileManager.NetType.DEFAULT));

        //通过文件路径获取下载地址
//        deserializeReturn(mFileManager.getDownloadUrlByFullPath("q.jpg",false, EntFileManager.NetType.DEFAULT));

        //创建文件夹
//        deserializeReturn(mFileManager.createFolder("test","Brandon"));

        //上传文件 文件不得超过50MB
//        deserializeReturn(mFileManager.createFile("WoWScrnShot_031415_175713.jpeg","Brandon","/Users/Brandon/Desktop/gugepinyinshurufa_427.apk"));

        //删除文件
//        deserializeReturn(mFileManager.del("test","Brandon"));

        //移动文件
//        deserializeReturn(mFileManager.move("test/test.txt","test.txt","Brandon"));

        //文件连接
//        deserializeReturn(mFileManager.link( "test.png", 0, EntFileManager.AuthType.DEFAULT, null));

        //发送消息
//        deserializeReturn(mFileManager.sendmsg(  "msgTest", "msg", "", "", "Brandon"));

        //获取当前库所有外链(new)
//        deserializeReturn(mFileManager.links( true));

        //文件分块上传
//        mFileManager.uploadByBlock( "test", "Brandon", 0, "/Users/Brandon/Desktop/SHA256-Swift-master.zip", true, new UploadCallBack() {
//
//            @Override
//            public void onSuccess(long threadId, String fileHash) {
//                System.out.println("success:" + threadId);
//
//            }
//
//            public void onFail(long threadId, String errorMsg) {
//                System.out.println("fail:" + threadId + " errorMsg:" + errorMsg);
//
//            }
//
//            public void onProgress(long threadId, float percent) {
//                System.out.println("onProgress:" + threadId + " onProgress:" + percent * 100);
//
//            }
//        });

        //通过链接上传文件
//        deserializeReturn(mFileManager.createFileByUrl("ppp", 0,
//                "Brandon", true, "http://img02.tooopen.com/images/20150614/tooopen_sy_130377131846.jpg"));

        //WEB直接上传文件 (支持50MB以上文件的上传)
//        deserializeReturn(mFileManager.getUploadServers());

//==========================云库企业操作==========================//
//        mEntManager = new EntManager(OauthConfig.CLIENT_ID, OauthConfig.CLIENT_SECRET);

        //获取角色
//        deserializeReturn(mEntManager.getRoles());

        //获取分组
//        deserializeReturn(mEntManager.getGroups());

        //获取成员
//        deserializeReturn(mEntManager.getMembers(0, 99));

        //根据成员Id查询企业成员信息
//        deserializeReturn(mEntManager.getMemberById(42));

        //根据外部系统唯一id查询企业成员信息
//        deserializeReturn(mEntManager.getMemberByOutId("dqwdqw"));

        //根据外部系统登录帐号查询企业成员信息
//        deserializeReturn(mEntManager.getMemberByAccount("nishuonishuo"));

        //分组成员列表
//        deserializeReturn(mEntManager.getGroupMembers(1086, 0, 3, true));

        //根据成员id获取成员个人库外链
//        deserializeReturn(mEntManager.getMemberFileLink(52, true));

        //添加或修改同步成员
//        deserializeReturn(mEntManager.addSyncMember("MemberTest1", "Member1", "Member1", "1234", "111", "111"));
//        deserializeReturn(mEntManager.addSyncMember("MemberTest2", "Member2", "Member2", "", "", ""));
//        deserializeReturn(mEntManager.addSyncMember("MemberTest3", "Member3", "Member3", "", "", ""));

        //添加或修改同步分组
//        deserializeReturn(mEntManager.delSyncMember(new String[]{"MemberTest", "MemberTest1", "MemberTest2"}));

//        deserializeReturn(mEntManager.addSyncGroup("ParentGroup", "ParentGroup", ""));
//        deserializeReturn(mEntManager.addSyncGroup("GroupTest", "Group", "ParentGroup"));


        //删除同步分组
//        deserializeReturn(mEntManager.delSyncGroup(new String[] { "ParentGroup", "GroupTest" }));

        //添加同步分组的成员

//        deserializeReturn(mEntManager.addSyncGroupMember("GroupTest",new String[]{"MemberTest1"}));
//        deserializeReturn(mEntManager.addSyncGroupMember("ParentGroup", new String[] { "MemberTest2","MemberTest3" }));

        //删除同步分组的成员
//        deserializeReturn(mEntManager.delSyncGroupMember("ParentGroup", new String[] { "MemberTest2", "MemberTest3" }));

    }

    /**
     * 解析返回内容
     *
     * @param result
     */
    private static void deserializeReturn(String result) {

        //解析结果
        ReturnResult returnResult = ReturnResult.create(result);

        if (returnResult.getStatusCode() == HttpURLConnection.HTTP_OK) {
            //成功的结果
            System.out.println("return 200");

        } else {
            //解析result中的内容
            BaseData data = BaseData.create(returnResult.getResult());
            if (data != null) {
                //如果可解析，则返回错误信息和错误号
                System.out.println(data.getErrorCode() + ":" + data.getErrorMsg());
            }
        }
        System.out.println(returnResult.getResult());
        //复制到剪贴板
        Util.copyToClipboard(returnResult.getResult());
    }


}

