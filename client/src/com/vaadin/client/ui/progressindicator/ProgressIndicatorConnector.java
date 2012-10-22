/*
 * Copyright 2011 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.vaadin.client.ui.progressindicator;

import com.google.gwt.user.client.Timer;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractFieldConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.progressindicator.ProgressIndicatorServerRpc;
import com.vaadin.shared.ui.progressindicator.ProgressIndicatorState;
import com.vaadin.ui.ProgressIndicator;

@Connect(ProgressIndicator.class)
public class ProgressIndicatorConnector extends AbstractFieldConnector {

    @Override
    public ProgressIndicatorState getState() {
        return (ProgressIndicatorState) super.getState();
    }

    ProgressIndicatorServerRpc rpc = RpcProxy.create(
            ProgressIndicatorServerRpc.class, this);

    private Timer poller = new Timer() {

        @Override
        public void run() {
            rpc.poll();
        }

    };

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        getWidget().setIndeterminate(getState().indeterminate);
        getWidget().setState(getState().state);

        if (isEnabled()) {
            poller.scheduleRepeating(getState().pollingInterval);
        } else {
            poller.cancel();
        }
    }

    @Override
    public VProgressIndicator getWidget() {
        return (VProgressIndicator) super.getWidget();
    }
}
