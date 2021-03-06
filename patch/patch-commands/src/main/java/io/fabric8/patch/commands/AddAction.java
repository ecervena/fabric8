/**
 *  Copyright 2005-2015 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package io.fabric8.patch.commands;

import java.net.URL;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import io.fabric8.patch.Patch;
import io.fabric8.patch.Service;

@Command(scope = "patch", name = "add", description = "Download a patch")
public class AddAction extends PatchActionSupport {

    @Option(name = "--bundles", description = "Show bundles contained in patches")
    boolean bundles;

    @Argument(required = true, multiValued = false)
    String url;

    AddAction(Service service) {
        super(service);
    }

    @Override
    protected void doExecute(Service service) throws Exception {
        Iterable<Patch> patches = service.download(new URL(url));
        display(patches, bundles);
    }

}
