// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: /Users/barathraghavan/code/murmur/murmur/buck-out/gen/proto-repo/compile_protobufs__srcs/CleartextMessages.proto
package org.denovogroup.murmur.objects;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Protobuf representation of a set of messages to be send over the wire to
 * a communication partner. Each message is a nested MobyMessage protobuf message.
 */
public final class CleartextMessages extends Message {

  public static final List<MobyMessage> DEFAULT_MESSAGES = Collections.emptyList();
    private static final String MESSAGES = "messages";

  /**
   * This is called a MobyMessage to avoid ambiguity with Wire.Message.
   * It represents a message and its priority.
   * A list of messages.
   */
  public final List<MobyMessage> messages;

  public CleartextMessages(ArrayList<MobyMessage> messages) {
    this.messages = (List<MobyMessage>) messages.clone();
  }

    public JSONObject toJson(Context context){
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for(MobyMessage message : messages){
            jsonArray.put(message.toJSON());
        }
        try {
            json.put(MESSAGES, jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static CleartextMessages fromJson(JSONObject json){
        try {
            JSONArray jsonArray = json.getJSONArray(MESSAGES);
            List<MobyMessage> messages = new ArrayList<>();
            for(int i=0; i<json.length(); i++){
                messages.add(MobyMessage.fromJSON((String) jsonArray.get(i)));
            }
            return new CleartextMessages((ArrayList<MobyMessage>) messages);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}