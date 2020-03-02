
import { CompanyWorkflowtypeItemOcrSettingPresetItem } from './company-workflowtyp-eitem-ocr-setting-preset-item';

export class CompanyWorkflowtypeItemOcrSettingPreset {
	companyIdentity: string = "";
	workflowIdentity: string = "";
	presetName: string = "";
	status: number = 1;
	version: number = 1;
	items: CompanyWorkflowtypeItemOcrSettingPresetItem[] = [];
  	
}
