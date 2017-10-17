package com.epoint.service;

import com.epoint.action.Configuration;

public class PanelAbstraction
{
    // 持有一个 PanelService 对象，形成聚合关系
    protected PanelService panelService;

    public PanelAbstraction(PanelService panelService) {
        this.panelService = panelService;
    }

    // 可能需要转调实现部分的具体实现
    public void operation(Configuration configuration) {
        panelService.SaveData(configuration);
    }
}
