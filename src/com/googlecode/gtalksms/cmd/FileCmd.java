package com.googlecode.gtalksms.cmd;

import java.io.File;

import com.googlecode.gtalksms.MainService;
import com.googlecode.gtalksms.XmppManager;

public class FileCmd extends Command {
    private XmppManager _xmppMgr;

    
    public FileCmd(MainService mainService) {
        super(mainService, new String[] {"send"});
        _xmppMgr = _mainService.getXmppmanager();
    }
    
    @Override
    protected void execute(String cmd, String args) {
        if (new File(args).exists()) {
            _xmppMgr.getXmppFileMgr().sendFile(args);
        } else {
            send("File '" + args + "' doesn't exist!");  // TODO localization
        }
    }
    
    @Override
    public String[] help() {
        return null;
    }

}
