package com.yunkuent.sdk;

import com.yunkuent.sdk.utils.Util;
import java.util.HashMap;

/**
 * Created by Brandon on 2014/8/14.
 */
public class EntManager extends OauthEngine {

    private static final String URL_API_GET_GROUPS = API_ENT_HOST + "/1/ent/get_groups";
    private static final String URL_API_GET_MEMBERS = API_ENT_HOST + "/1/ent/get_members";
    private static final String URL_API_GET_MEMBER = API_ENT_HOST + "/1/ent/get_member";
    private static final String URL_API_GET_ROLES = API_ENT_HOST + "/1/ent/get_roles";
    //    private static final String URL_API_SYNC_MEMBER = API_ENT_HOST + "/1/ent/sync_member";
    private static final String URL_API_GET_MEMBER_FILE_LINK = API_ENT_HOST + "/1/ent/get_member_file_link";
//    private static final String URL_API_GET_MEMBER_BY_OUT_ID = API_ENT_HOST + "/1/ent/get_member_by_out_id";

    private static final String URL_API_ADD_SYNC_MEMBER = API_ENT_HOST + "/1/ent/add_sync_member";
    private static final String URL_API_DEL_SYNC_MEMBER = API_ENT_HOST + "/1/ent/del_sync_member";
    private static final String URL_API_ADD_SYNC_GROUP = API_ENT_HOST + "/1/ent/add_sync_group";
    private static final String URL_API_DEL_SYNC_GROUP = API_ENT_HOST + "/1/ent/del_sync_group";
    private static final String URL_API_ADD_SYNC_GROUP_MEMBER = API_ENT_HOST + "/1/ent/add_sync_group_member";
    private static final String URL_API_DEL_SYNC_GROUP_MEMBER = API_ENT_HOST + "/1/ent/del_sync_group_member";
    private static final String URL_API_DEL_SYNC_MEMBER_GROUP = API_ENT_HOST + "/1/ent/del_sync_member_group";
    private static final String URL_API_GET_GROUP_MEMBERS = API_ENT_HOST + "/1/ent/get_group_members";

    public EntManager(String clientId, String clientSecret) {
        super(clientId, clientSecret, true);
    }

    /**
     * 获取角色
     *
     * @return
     */
    public String getRoles() {
        String url = URL_API_GET_ROLES;
        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", mClientId);
        params.put("dateline", Util.getUnixDateline() + "");
        params.put("sign", generateSign(params));
        return new RequestHelper().setParams(params).setUrl(url).setMethod(RequestMethod.GET).executeSync();
    }

    /**
     * 获取成员
     *
     * @param start
     * @param size
     * @return
     */
    public String getMembers(int start, int size) {
        String url = URL_API_GET_MEMBERS;
        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", mClientId);
        params.put("dateline", Util.getUnixDateline() + "");
        params.put("start", start + "");
        params.put("size", size + "");
        params.put("sign", generateSign(params));
        return new RequestHelper().setParams(params).setUrl(url).setMethod(RequestMethod.GET).executeSync();
    }


    private String getMember(int memberId, String outId, String account) {
        String url = URL_API_GET_MEMBER;
        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", mClientId);
        params.put("dateline", Util.getUnixDateline() + "");
        if (memberId > 0) {
            params.put("member_id", memberId + "");
        }
        params.put("out_id", outId);
        params.put("account", account);
        params.put("sign", generateSign(params));
        return new RequestHelper().setParams(params).setUrl(url).setMethod(RequestMethod.GET).executeSync();
    }

    /**
     * 根据成员id获取企业成员信息
     *
     * @param memberId
     * @return
     */

    public String getMemberById(int memberId) {
        return getMember(memberId, null, null);
    }

    /**
     * 根据外部id获取企业成员信息
     *
     * @param outId
     * @return
     */

    public String getMemberByOutId(String outId) {
        return getMember(0, outId, null);

    }

    /**
     * 根据帐号获取企业成员信息
     *
     * @param account
     * @return
     */

    public String getMemberByAccount(String account) {
        return getMember(0, null, account);
    }


    /**
     * 获取分组
     *
     * @return
     */
    public String getGroups() {
        String url = URL_API_GET_GROUPS;
        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", mClientId);
        params.put("dateline", Util.getUnixDateline() + "");
        params.put("sign", generateSign(params));
        return new RequestHelper().setParams(params).setUrl(url).setMethod(RequestMethod.GET).executeSync();
    }

    /**
     * 根据成员id获取成员个人库外链
     *
     * @param memberId
     * @return
     */

    public String getMemberFileLink(int memberId, boolean fileOnly) {
        String url = URL_API_GET_MEMBER_FILE_LINK;
        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", mClientId);
        params.put("dateline", Util.getUnixDateline() + "");
        params.put("member_id", memberId + "");
        if (fileOnly) {
            params.put("file", "1");
        }
        params.put("sign", generateSign(params));
        return new RequestHelper().setParams(params).setUrl(url).setMethod(RequestMethod.GET).executeSync();
    }

//    /**
//     * 根据外部成员id获取成员信息
//     *
//     * @return
//     */
//    public String getMemberByOutid(String outIds[]) {
//        if (outIds == null) {
//            throw new NullPointerException("outIds is null");
//        }
//        return getMemberByIds(null, outIds);
//
//    }
//
//    /**
//     * 根据外部成员登录帐号获取成员信息
//     *
//     * @return
//     */
//    public String getMemberByUserId(String[] userIds) {
//        if (userIds == null) {
//            throw new NullPointerException("userIds is null");
//        }
//        return getMemberByIds(userIds, null);
//    }

//    private String getMemberByIds(String[] userIds, String[] outIds) {
//        String method = "GET";
//        String url = URL_API_GET_MEMBER_BY_OUT_ID;
//        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("client_id", mClientId));
//        params.add(new BasicNameValuePair("dateline", Util.getUnixDateline() + ""));
//        if (outIds != null) {
//            params.add(new BasicNameValuePair("out_ids", Util.strArrayToString(outIds, ",") + ""));
//        } else {
//            params.add(new BasicNameValuePair("user_ids", Util.strArrayToString(userIds, ",") + ""));
//        }
//        params.add(new BasicNameValuePair("sign", generateSign(paramSorted(params))));
//        return NetConnection.sendRequest(url, method, params, null);
//    }

    /**
     * 添加或修改同步成员
     *
     * @param oudId
     * @param memberName
     * @param account
     * @param memberEmail
     * @param memberPhone
     * @param password    如果需要由够快验证帐号密码,密码为必须参数
     * @return
     */
    public String addSyncMember(String oudId, String memberName, String account, String memberEmail, String memberPhone, String password) {
        String url = URL_API_ADD_SYNC_MEMBER;
        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", mClientId);
        params.put("dateline", Util.getUnixDateline() + "");
        params.put("out_id", oudId);
        params.put("member_name", memberName);
        params.put("account", account);
        params.put("member_email", memberEmail);
        params.put("member_phone", memberPhone);
        params.put("password", password);
        params.put("sign", generateSign(params));
        return new RequestHelper().setParams(params).setUrl(url).setMethod(RequestMethod.POST).executeSync();
    }

    /**
     * 设置成员状态
     *
     * @param oudId
     * @return
     */
    public String setSyncMemberState(String oudId, boolean state) {
        String url = URL_API_ADD_SYNC_MEMBER;
        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", mClientId);
        params.put("dateline", Util.getUnixDateline() + "");
        params.put("out_id", oudId);
        params.put("state", state ? "1" : "0");
        params.put("sign", generateSign(params));
        return new RequestHelper().setParams(params).setUrl(url).setMethod(RequestMethod.POST).executeSync();
    }

    /**
     * 删除同步成员
     *
     * @param members
     * @return
     */
    public String delSyncMember(String[] members) {
        String url = URL_API_DEL_SYNC_MEMBER;
        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", mClientId);
        params.put("dateline", Util.getUnixDateline() + "");
        params.put("members", Util.strArrayToString(members, ","));
        params.put("sign", generateSign(params));
        return new RequestHelper().setParams(params).setUrl(url).setMethod(RequestMethod.POST).executeSync();
    }

    /**
     * 添加或修改同步分组
     *
     * @param outId
     * @param name
     * @param parentOutId
     * @return
     */
    public String addSyncGroup(String outId, String name, String parentOutId) {
        String url = URL_API_ADD_SYNC_GROUP;
        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", mClientId);
        params.put("dateline", Util.getUnixDateline() + "");
        params.put("out_id", outId);
        params.put("name", name);
        params.put("parent_out_id", parentOutId);
        params.put("sign", generateSign(params));
        return new RequestHelper().setParams(params).setUrl(url).setMethod(RequestMethod.POST).executeSync();
    }

    /**
     * 删除同步分组
     *
     * @param groups
     * @return
     */
    public String delSyncGroup(String[] groups) {
        String url = URL_API_DEL_SYNC_GROUP;
        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", mClientId);
        params.put("dateline", Util.getUnixDateline() + "");
        params.put("groups", Util.strArrayToString(groups, ","));
        params.put("sign", generateSign(params));
        return new RequestHelper().setParams(params).setUrl(url).setMethod(RequestMethod.POST).executeSync();
    }

    /**
     * 添加同步分组的成员
     *
     * @param groupOutId
     * @param members
     * @return
     */
    public String addSyncGroupMember(String groupOutId, String[] members) {
        String url = URL_API_ADD_SYNC_GROUP_MEMBER;
        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", mClientId);
        params.put("dateline", Util.getUnixDateline() + "");
        params.put("group_out_id", groupOutId);
        params.put("members", Util.strArrayToString(members, ","));
        params.put("sign", generateSign(params));
        return new RequestHelper().setParams(params).setUrl(url).setMethod(RequestMethod.POST).executeSync();
    }

    /**
     * 删除同步分组的成员
     *
     * @param groupOutId
     * @param members
     * @return
     */
    public String delSyncGroupMember(String groupOutId, String[] members) {
        String url = URL_API_DEL_SYNC_GROUP_MEMBER;
        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", mClientId);
        params.put("dateline", Util.getUnixDateline() + "");
        params.put("group_out_id", groupOutId);
        params.put("members", Util.strArrayToString(members, ","));
        params.put("sign", generateSign(params));
        return new RequestHelper().setParams(params).setUrl(url).setMethod(RequestMethod.POST).executeSync();
    }

    /**
     * 分组成员列表
     *
     * @param groupId
     * @param start
     * @param size
     * @param showChild
     * @return
     */
    public String getGroupMembers(int groupId, int start, int size, boolean showChild) {
        String url = URL_API_GET_GROUP_MEMBERS;
        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", mClientId);
        params.put("dateline", Util.getUnixDateline() + "");
        params.put("group_id", groupId + "");
        params.put("start", start + "");
        params.put("size", size + "");
        params.put("show_child", (showChild ? 1 : 0) + "");
        params.put("sign", generateSign(params));
        return new RequestHelper().setParams(params).setUrl(url).setMethod(RequestMethod.GET).executeSync();
    }

    /**
     * 删除成员的所有同步分组
     *
     * @param members
     * @return
     */
    public String delSyncMemberGroup(String[] members) {
        String url = URL_API_DEL_SYNC_MEMBER_GROUP;
        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", mClientId);
        params.put("dateline", Util.getUnixDateline() + "");
        params.put("members", Util.strArrayToString(members, ","));
        params.put("sign", generateSign(params));
        return new RequestHelper().setParams(params).setUrl(url).setMethod(RequestMethod.POST).executeSync();
    }


    /**
     * 复制一个EntManager对象
     *
     * @return
     */
    public EntManager clone() {
        return new EntManager(mClientId, mClientSecret);
    }

}
