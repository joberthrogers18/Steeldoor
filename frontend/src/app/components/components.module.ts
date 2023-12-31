import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenubarModule } from 'primeng/menubar';

import { HeaderComponent } from './header/header.component';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
@NgModule({
  declarations: [HeaderComponent],
  imports: [CommonModule, MenubarModule, FormsModule],
  exports: [HeaderComponent],
})
export class ComponentsModule {}
